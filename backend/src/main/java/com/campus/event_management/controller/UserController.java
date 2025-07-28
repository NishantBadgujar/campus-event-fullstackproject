package com.campus.event_management.controller;

import com.campus.event_management.entity.User;
import com.campus.event_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService service;


    @PostMapping("create")
    public User createUser(@RequestBody User user){
        return service.createUser(user);
    }

    @GetMapping("getAll")
    public List<User> getAll(){
        return service.getAllUser();
    }

    @GetMapping("get/{id}")
    public User getUser(@PathVariable long id){
        return service.getUserById(id);
    }

    @PutMapping("update/{id}")
    public User updateUser(@RequestBody User user, @PathVariable long id){
        return service.updateUser(user,id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable long id){
        return service.deleteUser(id);
    }
}
