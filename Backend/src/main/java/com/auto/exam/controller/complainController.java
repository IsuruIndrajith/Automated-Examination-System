package com.auto.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto.exam.Model.Complain;
import com.auto.exam.service.complainService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/complain")
public class complainController {

    private complainService complainService;

    @Autowired
    public complainController(complainService complainService) {
        this.complainService = complainService;
    }

    @PostMapping("/addComplain")
    public ResponseEntity<?> addComplain(@RequestBody Complain complain) {

        System.out.println("Complain================================: " + complain);
        try {
            complainService.addComplain(complain);
            return ResponseEntity.ok("Complain added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding complain: " + e.getMessage());
        }
    }


    @PostMapping("/showComplain")
    public ResponseEntity<?> showComplain() {
        try {
            List<Complain> complains = complainService.getAllComplains();
            return ResponseEntity.ok(complains);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching complains: " + e.getMessage());
        }
    }

    
        
}
