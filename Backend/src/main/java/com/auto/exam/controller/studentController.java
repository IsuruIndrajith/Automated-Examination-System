package com.auto.exam.controller;

import com.auto.exam.Model.Student;
import com.auto.exam.service.studentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
