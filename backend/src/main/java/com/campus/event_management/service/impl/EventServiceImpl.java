package com.campus.event_management.service.impl;

import com.campus.event_management.entity.Event;
import com.campus.event_management.repository.EventRepository;
import com.campus.event_management.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository repo;


    @Override
    public Event create(Event event) {
        return repo.save(event);
    }

    @Override
    public List<Event> getAllEvent() {
        return repo.findAll();
    }

    @Override
    public Event getEventById(long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Event updateEvent(Event event, long id) {
        Event newEvent = repo.findById(id).orElse(null);
        if(newEvent!=null){
            newEvent.setTitle(event.getTitle());
            newEvent.setDescription(event.getDescription());
            newEvent.setDateTime(event.getDateTime());
            newEvent.setVenue(event.getVenue());
            newEvent.setCapacity(event.getCapacity());
            newEvent.setOrganizer(event.getOrganizer());
            repo.save(newEvent);

        }
        return null;
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }
}
