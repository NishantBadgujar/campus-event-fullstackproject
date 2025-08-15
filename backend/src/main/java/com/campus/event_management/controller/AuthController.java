//package com.campus.event_management.controller;
//
//import com.campus.event_management.entity.User;
//import com.campus.event_management.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/signup")
//    public ResponseEntity<User> register(@RequestBody User user) {
//        if (userService.getUserByEmail(user.getEmail()) != null) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).build();
//        }
//        User savedUser = userService.registerUser(user);
//        return ResponseEntity.ok(savedUser);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<User> login(@RequestBody Map<String, String> loginData) {
//        String email = loginData.get("email");
//        String password = loginData.get("password");
//        User user = userService.loginUser(email, password);
//        if (user != null) {
//            return ResponseEntity.ok(user);
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//    }
//}
