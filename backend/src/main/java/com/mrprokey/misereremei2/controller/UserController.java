package com.mrprokey.misereremei2.controller;

import com.mrprokey.misereremei2.model.User;
import com.mrprokey.misereremei2.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        // Implement registration logic here, e.g., encoding password
        return userService.save(user);
    }

    @GetMapping("/login")
    public Optional<User> login(@RequestParam String username) {
        // Implement login logic here
        return userService.findByUsername(username);
    }
}
