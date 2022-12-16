package com.techelevator.dao;

import com.techelevator.model.Address;
import com.techelevator.model.Event;
import com.techelevator.model.EventNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcEventDao implements EventDao {
    public final JdbcTemplate jdbcTemplate;
    public JdbcEventDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Event> listEvents() {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT event.event_id, event_name, start_time, end_time, event_date, " +
                "event_description, image_url, resource_name, address_1, address_2, city, state, zip, " +
                "host_name, host_description, host_img FROM event " +
                "JOIN event_resource_type ON event.event_id = event_resource_type.event_id " +
                "JOIN resource_type ON event_resource_type.resource_type_id = resource_type.resource_type_id " +
                "JOIN event_address ON event.event_id = event_address.event_id " +
                "JOIN address ON address.address_id = event_address.address_id " +
                "JOIN host_event ON host_event.event_id = event.event_id " +
                "JOIN host ON host.host_id = host_event.host_id " +
                "ORDER BY event_date, start_time";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while(rowSet.next()) {
            eventList.add(mapRowToEvent(rowSet));
        }
        return eventList;
    }

    public List<Event> listHostEvents(int id) {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT event.event_id, event_name, start_time, end_time, event_date, " +
                "event_description, image_url, resource_name, address_1, address_2, city, state, zip, " +
                "host_name, host_description, host_img FROM event " +
                "JOIN event_resource_type ON event.event_id = event_resource_type.event_id " +
                "JOIN resource_type ON event_resource_type.resource_type_id = resource_type.resource_type_id " +
                "JOIN event_address ON event.event_id = event_address.event_id " +
                "JOIN address ON address.address_id = event_address.address_id " +
                "JOIN host_event ON host_event.event_id = event.event_id " +
                "JOIN host ON host.host_id = host_event.host_id " +
                "WHERE host.host_id = ? ORDER BY event_date, start_time";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);
        while(rowSet.next()) {
            eventList.add(mapRowToEvent(rowSet));
        }
        return eventList;
    }

    public int addEventHostAddress(Event event) {
        if (event.getStartTime().contains("AM") || event.getStartTime().contains("PM")){ event = handleConvertTime(event);}
        LocalTime startTime = LocalTime.parse(event.getStartTime());
        LocalTime endTime = LocalTime.parse(event.getEndTime());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date eventDate = null;
        try {
            eventDate = dateFormat.parse(event.getEventDate());
        }
        catch (ParseException e) {
            System.out.println("error parsing date");
        }

        String sqlAdd = "INSERT INTO event (event_name, start_time, end_time, event_date, event_description, image_url) " +
                "VALUES (?,?,?,?,?,?) RETURNING event_id";

        Integer eventId = 0;
        eventId = jdbcTemplate.queryForObject(sqlAdd, Integer.class, event.getName(), startTime,
                endTime, eventDate, event.getDescription(), event.getImg());

        return eventId;
    }

    public Event handleConvertTime(Event event) {
        String[] strs = null;
        if (event.getStartTime().contains("AM") || event.getStartTime().contains("PM")) {
            strs = event.getStartTime().split(" ");
            if (strs[1].equals("AM")) {
                event.setStartTime(strs[0]);
            } else {
                int hr = Integer.parseInt(strs[0].substring(0, 2));
                hr += 12;
                event.setStartTime(hr + strs[0].substring(2));
            }
        }
        if (event.getEndTime().contains("AM") || event.getEndTime().contains("PM")) {
            strs = event.getEndTime().split(" ");
            if (strs[1].equals("AM")) {
                event.setEndTime(strs[0]);
            } else {
                int hr = Integer.parseInt(strs[0].substring(0, 2));
                hr += 12;
                event.setEndTime(hr + strs[0].substring(2));
            }
        }
        return event;
    }

    public int[] retrieveIdNumbersForInserts(Event event) {
        int[] ids = new int[3];
        ids[0] = handleRetrieveHostId(event.getHost());
        ids[1] = handleRetrieveAddressId(event.getAddress());
        ids[2] =handleRetrieveResourceId(event.getResourceName());

        return ids;
    }

    private int handleRetrieveHostId(String hostName) {
        String sqlRetrieval = "SELECT host_id FROM host WHERE host_name = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sqlRetrieval, hostName);
        int id = 0;
        if (rowSet.next()) { id = rowSet.getInt("host_id");}
        return id;
    }

    private int handleRetrieveAddressId(Address address) {
        String sqlRetrieval = "SELECT address_id FROM address " +
                "WHERE address_1 = ? AND address_2 = ? AND city = ? AND state = ? AND zip = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sqlRetrieval, address.getAddress1(), address.getAddress2(), address.getCity(), address.getState(), address.getZip());
        if (rowSet.next()) {
            return rowSet.getInt("address_id");
        }
        else {
            return handleAddAddress(address);
        }
    }

    private int handleRetrieveResourceId(String name) {
        if (name.equals("Grooming")) {name = "Grooming (haircuts, etc)";}
        if (name.equals("Health")) {name = "Health (dental visits, vaccination sites)";}
        if (name.equals("Education")) {name = "Education (free workshops, library events)";}
        String sqlRetrieval = "SELECT resource_type_id FROM resource_type " +
                "WHERE resource_name = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sqlRetrieval, name);
        int id = 0;
        if (rowSet.next()) {
            id = rowSet.getInt("resource_type_id");
        }
        return id;
    }

    private int handleAddAddress(Address address) {
        String sqlAddAddress = "INSERT INTO address (address_1, address_2, city, state, zip) VALUES (?,?,?,?,?) RETURNING address_id";
        Integer addressId = jdbcTemplate.queryForObject(sqlAddAddress, Integer.class,
                address.getAddress1(), address.getAddress2(), address.getCity(), address.getState(), address.getZip());
        return addressId;
    }

    public void addToIntermediaryTables(int[] ids, int eventId) {
        String sqlAdd = "INSERT INTO host_event (event_id, host_id) VALUES (?,?)";
        jdbcTemplate.update(sqlAdd, eventId, ids[0]);

        sqlAdd = "INSERT INTO event_address (event_id, address_id) VALUES (?,?)";
        jdbcTemplate.update(sqlAdd, eventId, ids[1]);

        sqlAdd = "INSERT INTO event_resource_type (event_id, resource_type_id) VALUES (?,?)";
        jdbcTemplate.update(sqlAdd, eventId, ids[2]);
    }

    public void deleteEvent(int id) throws EventNotFoundException {
        String sqlSelect = "SELECT event_name FROM event WHERE event_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelect, id);
        if (results.next()) {
            String sqlDelete = "DELETE FROM host_event WHERE event_id = ?";
            jdbcTemplate.update(sqlDelete, id);

            sqlDelete = "DELETE FROM event_address WHERE event_id = ?";
            jdbcTemplate.update(sqlDelete, id);

            sqlDelete = "DELETE FROM event_resource_type WHERE event_id = ?";
            jdbcTemplate.update(sqlDelete, id);

            sqlDelete = "DELETE FROM event WHERE event_id = ?";
            jdbcTemplate.update(sqlDelete, id);
        }
        else {
            throw new EventNotFoundException();
        }
    }

    public void updateEvent(Event event) throws EventNotFoundException {
        if (event.getStartTime().contains("AM") || event.getStartTime().contains("PM") || event.getEndTime().contains("AM") || event.getEndTime().contains("PM")){ event = handleConvertTime(event);}
        LocalTime startTime = LocalTime.parse(event.getStartTime());
        LocalTime endTime = LocalTime.parse(event.getEndTime());
        DateFormat dateFormat = null;
        if (event.getEventDate().contains("/")) {
            dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        }
        else {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        }
        Date eventDate = null;
        try {
            eventDate = dateFormat.parse(event.getEventDate());
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        String sqlUpdate = "UPDATE event " +
                "SET event_name = ?, event_description = ?, start_time = ?, end_time = ?, " +
                "event_date = ?, image_url = ? " +
                "WHERE event_id = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet("SELECT * FROM event WHERE event_id = ?", event.getEventId());
        if (!rowSet.next()) {
            throw new EventNotFoundException();
        }

        try {
           jdbcTemplate.update(sqlUpdate, event.getName(), event.getDescription(), startTime, endTime,
                    eventDate, event.getImg(), event.getEventId());
        }
        catch (Exception e) {
            throw new EventNotFoundException();
        }

        int addressId = handleRetrieveAddressId(event.getAddress());
        sqlUpdate = "UPDATE event_address SET address_id = ? WHERE event_id = ?";
        jdbcTemplate.update(sqlUpdate, addressId, event.getEventId());

        int resourceId = handleRetrieveResourceId(event.getResourceName());
        sqlUpdate = "UPDATE event_resource_type SET resource_type_id = ? WHERE event_id = ?";
        jdbcTemplate.update(sqlUpdate, resourceId, event.getEventId());
    }

    public Event retrieveEvent(int id) {
        Event event = null;
        String sql = "SELECT event.event_id, event_name, start_time, end_time, event_date, " +
                "event_description, image_url, resource_name, address_1, address_2, city, state, zip, " +
                "host_name, host_description, host_img FROM event " +
                "JOIN event_resource_type ON event.event_id = event_resource_type.event_id " +
                "JOIN resource_type ON event_resource_type.resource_type_id = resource_type.resource_type_id " +
                "JOIN event_address ON event.event_id = event_address.event_id " +
                "JOIN address ON address.address_id = event_address.address_id " +
                "JOIN host_event ON host_event.event_id = event.event_id " +
                "JOIN host ON host.host_id = host_event.host_id " +
                "WHERE event.event_id = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);

        if (rowSet.next()) {
            event = mapRowToEvent(rowSet);
        }
        return event;
    }

    private Event mapRowToEvent(SqlRowSet rowSet) {
        Address address = new Address();
        address.setAddress1(rowSet.getString("address_1"));
        address.setAddress2(rowSet.getString("address_2"));
        address.setCity(rowSet.getString("city"));
        address.setState(rowSet.getString("state"));
        address.setZip(rowSet.getString("zip"));
        Event event = new Event();
        event.setEventId(rowSet.getInt("event_id"));
        event.setName(rowSet.getString("event_name"));
        DateFormat dateFormat = new SimpleDateFormat("hh:mm aa");
        String dateString = dateFormat.format(rowSet.getTimestamp("start_time"));
        event.setStartTime(dateString);
        dateString = dateFormat.format(rowSet.getTimestamp("end_time"));
        event.setEndTime(dateString);
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateString = dateFormat.format(rowSet.getDate("event_date"));
        event.setEventDate(dateString);
        event.setDescription(rowSet.getString("event_description"));
        if (event.getDescription().length() > 50) {
            event.setShortDescription(event.getDescription().substring(0, 45) + "... Click \"See More\" for more info");
        }
        else {
            event.setShortDescription(event.getDescription());
        }
        event.setImg(rowSet.getString("image_url"));
        String rawResourceName = rowSet.getString("resource_name");
        if (rawResourceName.contains("(")) {
            event.setResourceName(rawResourceName.split("\\(")[0].strip());
        }
        else {
            event.setResourceName(rawResourceName);
        }
        event.setAddress(address);
        event.setHost(rowSet.getString("host_name"));
        event.setHost_description(rowSet.getString("host_description"));
        event.setHostImg(rowSet.getString("host_img"));
        return event;
    }
}
