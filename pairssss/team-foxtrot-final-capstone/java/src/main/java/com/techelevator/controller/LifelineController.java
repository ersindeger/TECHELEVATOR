package com.techelevator.controller;

import com.techelevator.dao.EventDao;
import com.techelevator.dao.HostDao;
import com.techelevator.model.Event;

import com.techelevator.model.EventNotFoundException;
import com.techelevator.model.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@CrossOrigin
public class LifelineController {
    @Autowired
    private EventDao eventDao;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Event> listHomeEvents() {
        return eventDao.listEvents();
    }         //this is added for HomePage... to pull a list of events.

    @RequestMapping(path = "/demo", method = RequestMethod.GET)
    public List<Event> listEvents() {
        return eventDao.listEvents();
    }

    @RequestMapping(path = "/host/{id}", method = RequestMethod.GET)
    public List<Event> listHostEvents(@PathVariable int id) {
        return eventDao.listHostEvents(id);
    }

    @RequestMapping(path = "/host/event/{id}", method = RequestMethod.GET)
    public Event retrieveEvent(@PathVariable int id) {
        Event event = eventDao.retrieveEvent(id);
        if (event == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else {
            return event;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/host/event", method = RequestMethod.POST)
    public void addEvent(@RequestBody Event event) {

        int eventId = eventDao.addEventHostAddress(event);
        if (eventId > 0) {
            int[] ids = eventDao.retrieveIdNumbersForInserts(event);
            eventDao.addToIntermediaryTables(ids, eventId);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/host/event/{id}", method = RequestMethod.DELETE)
    public void deleteEvent(@PathVariable int id) throws EventNotFoundException {
        eventDao.deleteEvent(id);
    }

    @RequestMapping(path = "/host/event/{id}", method = RequestMethod.PUT)
    public void updateEvent(@PathVariable int id, @RequestBody Event event) throws EventNotFoundException {
        eventDao.updateEvent(event);
    }

}

