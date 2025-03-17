package com.auto.exam.controller;

import com.auto.exam.Model.Student;
import com.auto.exam.Model.User;
import com.auto.exam.repo.userRepo;
import com.auto.exam.service.studentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class studentController {
    private final studentDetailsService studentDetailsService;

    @Autowired
    public studentController(com.auto.exam.service.studentDetailsService studentDetailsService) {
        this.studentDetailsService = studentDetailsService;
    }

    @Autowired
    private userRepo userRepo;


    @GetMapping("/getall")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> st = studentDetailsService.get_student();
        return new ResponseEntity<>(st, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student newStudent = studentDetailsService.save_student(student);
        System.out.println(newStudent.toString());
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @GetMapping("/profile")
    public  User getUserProfile() {
        System.out.println("======================");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("======================"+authentication.getName());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepo.findByUsername(username);
    }
}
