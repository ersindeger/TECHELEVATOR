package com.techelevator.dao;

import com.techelevator.model.Address;
import com.techelevator.model.Event;
import com.techelevator.model.EventNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcEventDaoTests extends BaseDaoTests{
    private Event event = null;
    private  JdbcEventDao sut;
    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcEventDao(jdbcTemplate);

        event = new Event();
        event.setName("Service");
        event.setResourceName("Childcare");
        event.setHost("United Methodist Church & Community Development for All People");
        event.setHost_description("Church");
        event.setStartTime("10:00 AM");
        event.setEndTime("11:00 AM");
        event.setDescription("Attend service");
        event.setImg("url");
        event.setEventDate("12/30/2022");
        event.setHostImg("host img");

        Address address = new Address();
        address.setAddress1("946 Parsons Ave");
        address.setAddress2("");
        address.setCity("Columbus");
        address.setState("OH");
        address.setZip("43206");
        event.setAddress(address);
    }

    @Test
    public void list_events_returns_correct_length_of_events (){
       List<Event> list_of_events = sut.listEvents();

        Assert.assertEquals(2, list_of_events.size());
    }

    @Test
    public void list_events_returns_correct_data () {
        List<Event> list_of_events = sut.listEvents();

        Assert.assertEquals("Haircuts for All People", list_of_events.get(0).getName());
        Assert.assertEquals("Free Store", list_of_events.get(1).getName());
    }

    @Test
    public void retrieve_id_numbers_for_inserts_returns_correct_data() {
        int[] ids = sut.retrieveIdNumbersForInserts(event);
        Assert.assertEquals(1,ids[0]);
        Assert.assertEquals(1,ids[1]);
        Assert.assertEquals(8,ids[2]);
    }

    @Test
    public void list_host_events_returns_correct_data() {
        List<Event> eventList = sut.listHostEvents(1);

        Assert.assertEquals("Haircuts for All People", eventList.get(0).getName());
        Assert.assertEquals("Free Store", eventList.get(1).getName());
    }

    @Test
    public void list_host_events_returns_not_data_when_does_not_exist() {
        List<Event> eventList = sut.listHostEvents(2);

        Assert.assertEquals(0, eventList.size());
    }

    @Test
    public void add_event_adds_event() {
        int eventId = sut.addEventHostAddress(event);
        int[] ids = sut.retrieveIdNumbersForInserts(event);
        sut.addToIntermediaryTables(ids, eventId);
        List<Event> eventList = sut.listEvents();
        Assert.assertEquals(3, eventList.size());
        Assert.assertEquals("Service", eventList.get(2).getName());
    }

    @Test
    public void add_event_adds_address_if_does_not_exist() {
        event.getAddress().setAddress1("91283");
        int eventId = sut.addEventHostAddress(event);
        int[] ids = sut.retrieveIdNumbersForInserts(event);
        sut.addToIntermediaryTables(ids, eventId);
        List<Event> eventList = sut.listEvents();
        Assert.assertEquals(3, eventList.size());
        Assert.assertEquals(2, sut.retrieveIdNumbersForInserts(event)[1]);
    }

    @Test
    public void retrieve_event_returns_correct_data_if_exists() {
        Event retrievedEvent = sut.retrieveEvent(1);

        Assert.assertEquals("Haircuts for All People", retrievedEvent.getName());
    }

    @Test
    public void retrieve_event_returns_no_data_if_does_not_exist() {
        Event retrievedEvent = sut.retrieveEvent(1000);

        Assert.assertNull(retrievedEvent);
    }

    @Test
    public void delete_event_deletes_event_if_found() {
        try {
            sut.deleteEvent(1);
        } catch (EventNotFoundException e) {
            System.out.println("Event not found.");
        }

        List<Event> eventList = sut.listEvents();
        Assert.assertEquals(1, eventList.size());
    }

    @Test
    public void delete_event_does_not_delete_event_if_not_found() {
        try {
            sut.deleteEvent(100);
        } catch (EventNotFoundException e) {
            System.out.println("Event not found.");
        }

        List<Event> eventList = sut.listEvents();
        Assert.assertEquals(2, eventList.size());
    }

    @Test
    public void update_event_updates_event_if_found() {
        event.setEventId(1);
        try {
            sut.updateEvent(event);
        }
        catch (EventNotFoundException e) {
            System.out.println("Event not found");
        }

        Event updatedEvent = sut.retrieveEvent(1);
        Assert.assertEquals(event.getName(), updatedEvent.getName());
    }

    @Test
    public void update_event_does_not_update_event_if_not_found() {
        event.setEventId(100);
        try {
            sut.updateEvent(event);
        }
        catch (EventNotFoundException e) {
            System.out.println("Event not found");
            Assert.assertTrue(true);
        }
    }


}
