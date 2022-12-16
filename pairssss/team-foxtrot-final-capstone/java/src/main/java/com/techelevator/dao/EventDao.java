package com.techelevator.dao;

import com.techelevator.model.Event;
import com.techelevator.model.EventNotFoundException;

import java.util.List;

public interface EventDao {
    List<Event> listEvents();

    List<Event> listHostEvents(int id);

    int[] retrieveIdNumbersForInserts(Event event);

    int addEventHostAddress(Event event);

    void addToIntermediaryTables(int[] ids, int eventId);

    void deleteEvent(int id) throws EventNotFoundException;

    void updateEvent(Event event) throws EventNotFoundException;

    Event retrieveEvent(int id);
}
