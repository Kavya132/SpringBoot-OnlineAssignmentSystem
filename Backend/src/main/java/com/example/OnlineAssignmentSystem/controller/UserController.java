package com.example.OnlineAssignmentSystem.controller;

import com.example.OnlineAssignmentSystem.model.User;
import com.example.OnlineAssignmentSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint to sign up a new user
    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return userService.saveUser(user); // Save user with encrypted password
    }

    // Endpoint for user login (using loadUserByUsername method from UserDetailsService)
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return (User) userService.loadUserByUsername(user.getUsername()); // Use UserService's loadUserByUsername method
    }
}
