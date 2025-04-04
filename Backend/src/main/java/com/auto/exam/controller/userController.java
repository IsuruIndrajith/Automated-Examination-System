package com.auto.exam.controller;

import com.auto.exam.Dto.Login;
import com.auto.exam.Model.User;
import com.auto.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*") 
public class userController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public Login login(@RequestBody User user) {
        return service.verify(user);
    }
}

