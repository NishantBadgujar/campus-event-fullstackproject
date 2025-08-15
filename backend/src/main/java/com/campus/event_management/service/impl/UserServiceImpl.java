package com.campus.event_management.service.impl;

import com.campus.event_management.entity.User;
import com.campus.event_management.repository.UserRepository;
import com.campus.event_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repo;

//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
    @Override
    public User registerUser(User user) {
        return repo.save(user);
    }
//
//    @Override
//    public User loginUser(String email, String password) {
//        User user = repo.findByEmail(email).orElse(null);
//        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//            return user;
//        }
//        return null;
//    }
//
//    @Override
//    public User getUserByEmail(String email) {
//        return repo.findByEmail(email).orElse(null);
//    }

    @Override
    public List<User> getAllUser(){
        return repo.findAll();
    }

    @Override
    public User getUserById(long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public String deleteUser(long id){
        repo.deleteById(id);
        return "User deleted Successfully.";
    }

    @Override
    public User updateUser(User user, long id){
        User odlUser = repo.findById(id).orElse(null);

        if(odlUser != null) {
            odlUser.setName(user.getName());
            odlUser.setEmail(user.getEmail());
            odlUser.setPassword(user.getPassword());
            odlUser.setRole(user.getRole());

            return repo.save(odlUser);
        }
        return null;
    }
}
