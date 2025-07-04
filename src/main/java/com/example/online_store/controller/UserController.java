package com.example.online_store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.online_store.models.user.UserRequest;
import com.example.online_store.models.user.UserResponse;
import com.example.online_store.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/{userId}")
    public UserResponse view(@PathVariable("userId") Long userId) {
        return userService.view(userId);
    }

    @PostMapping
    public UserResponse create(@org.springframework.web.bind.annotation.RequestBody @Valid UserRequest userRequest) {
        return userService.createUser(userRequest);
    }
}
