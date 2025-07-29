package com.campus.event_management.service.impl;

import com.campus.event_management.entity.Event;
import com.campus.event_management.entity.Registration;
import com.campus.event_management.entity.User;
import com.campus.event_management.repository.EventRepository;
import com.campus.event_management.repository.RegistrationRepository;
import com.campus.event_management.repository.UserRepository;
import com.campus.event_management.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    RegistrationRepository registerRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    EventRepository eventRepo;


    @Override
    public Registration registerUser(long userId, long eventId) {

        User user = userRepo.findById(userId).orElse(null);
        Event event = eventRepo.findById(eventId).orElse(null);

        if(user != null && event != null){

            Registration registration = new Registration();
            registration.setUser(user);
            registration.setEvent(event);
            return registerRepo.save(registration);
        }
        return null;
    }

    @Override
    public List<Registration> getAllReg() {
        return registerRepo.findAll();
    }

    @Override
    public Registration getRegByID(long id) {
        return registerRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteReg(long id) {
        registerRepo.deleteById(id);
    }
}
