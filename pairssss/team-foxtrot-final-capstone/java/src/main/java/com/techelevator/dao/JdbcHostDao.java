package com.techelevator.dao;

import com.techelevator.model.Host;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcHostDao implements HostDao {

    public final JdbcTemplate jdbcTemplate;
    public JdbcHostDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Host retrieveHost(int id) {
        Host host = null;
        String sql = "SELECT host_id, host_name, host_description, host_img FROM HOST " +
                "WHERE host_id = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);

        if ((rowSet.next())) {
            host = mapRowToHost(rowSet);
        }

        return host;
    }
    private Host mapRowToHost(SqlRowSet rowSet) {
        Host host = new Host();

        host.setHost_description(rowSet.getString("host_description"));
        host.setHost_id(rowSet.getInt("host_id"));
        host.setHost_img(rowSet.getString("host_img"));
        host.setHost_name(rowSet.getString("host_name"));

        return host;
    }
}
