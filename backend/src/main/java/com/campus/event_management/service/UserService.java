package com.campus.event_management.service;

import com.campus.event_management.entity.User;
import com.campus.event_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public User createUser(User user){
        return repo.save(user);
    }

    public List<User> getAllUser(){
        return repo.findAll();
    }

    public User getUserById(long id){
        return repo.findById(id).orElse(null);
    }

    public String deleteUser(long id){
        repo.deleteById(id);
        return "User Deleted Successfully.";
    }

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
