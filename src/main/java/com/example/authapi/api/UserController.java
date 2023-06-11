package com.example.authapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.authapi.model.User;
import com.example.authapi.service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String getUsers() {
        return service.getUsers();
    }

    @PostMapping
    public String addUser(@RequestBody User newUser) {
        return service.addUser(newUser);
    }

}
