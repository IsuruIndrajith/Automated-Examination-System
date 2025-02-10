package com.pankaja.project1.controller;

import com.pankaja.project1.model.User;
import com.pankaja.project1.service.UserSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class USerController {

        @Autowired
        UserSerivice service;

        @GetMapping("/register")
        public User URegUser(@RequestBody User user){

            return service.RegisterUser(user);
        }

        @PostMapping ("/")
        public void Something(){
            System.out.println("user");
        }

        @PostMapping("/login")
        public String login(@RequestBody User user){
            return service.VeryfyUser(user);
        }

}
