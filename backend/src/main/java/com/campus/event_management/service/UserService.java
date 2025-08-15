package com.campus.event_management.service;

import com.campus.event_management.entity.User;

import java.util.List;

public interface UserService {

    User registerUser(User user);
//    User loginUser(String email, String password);
//    User getUserByEmail(String email);
    List<User> getAllUser();
    User getUserById(long id);
    User updateUser(User user, long id);
    String deleteUser(long id);
}
