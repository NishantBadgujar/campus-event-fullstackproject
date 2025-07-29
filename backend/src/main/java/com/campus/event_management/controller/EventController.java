package com.campus.event_management.controller;

import com.campus.event_management.entity.Event;
import com.campus.event_management.service.EventService;
import com.campus.event_management.service.impl.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    EventService service;

    @PostMapping("createEvent")
    public Event createEvent(@RequestBody Event event){
        return service.create(event);
    }

    @GetMapping("getEvents")
    public List<Event> getAllEvents(){
        return service.getAllEvent();
    }

    @GetMapping("getEvent/{id}")
    public Event getById(@PathVariable long id){
        return service.getEventById(id);
    }

    @PutMapping("updateEvent/{id}")
    public Event updateEvent(@RequestBody Event event, @PathVariable long id){
        return service.updateEvent(event, id);
    }

    @DeleteMapping("deleteEvent/{id}")
    public void deleteEvent(@PathVariable long id){
        service.delete(id);
    }

}
