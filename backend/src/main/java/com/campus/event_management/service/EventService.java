package com.campus.event_management.service;

import com.campus.event_management.entity.Event;
import com.campus.event_management.repository.EventRepository;

import java.util.List;

public interface EventService {

    Event create(Event event);
    List<Event> getAllEvent();
    Event getEventById(long id);
    Event updateEvent(Event event, long id);
    void delete(long id);
}
