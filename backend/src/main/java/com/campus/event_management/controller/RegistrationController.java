package com.campus.event_management.controller;

import com.campus.event_management.entity.Registration;
import com.campus.event_management.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {

    @Autowired
    RegistrationService service;

    @PostMapping("registerUser")
    public ResponseEntity<Registration> registerUser(@RequestParam long userId, @RequestParam long eventId){

        Registration reg = service.registerUser(userId,eventId);
        if(reg != null){
            return ResponseEntity.ok(reg);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("getAllReg")
    public ResponseEntity<List<Registration>> getAllReg(){
        return ResponseEntity.ok(service.getAllReg());
    }
//
    @GetMapping("getRegById/{id}")
    public ResponseEntity<Registration> getRegById(@PathVariable long id){
        Registration reg = service.getRegByID(id);
        if(reg!=null){
            return ResponseEntity.ok(reg);
        }
        return ResponseEntity.notFound().build();
    }
//
    @DeleteMapping("deleteReg/{id}")
    public ResponseEntity<Void> deleteReg(@PathVariable long id){
        service.deleteReg(id);
        return ResponseEntity.noContent().build();
    }
}
