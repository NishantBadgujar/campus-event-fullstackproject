    package com.campus.event_management.service;

    import com.campus.event_management.entity.Registration;

    import java.util.List;

    public interface RegistrationService {

        Registration registerUser(long userId, long eventId);
        List<Registration> getAllReg();
        Registration getRegByID(long id);
        void deleteReg(long id);
    }
