package com.auto.exam.controller;

import com.auto.exam.Model.Course;
import com.auto.exam.Model.Exam;
import com.auto.exam.Model.Student;
import com.auto.exam.Model.User;
import com.auto.exam.repo.userRepo;
import com.auto.exam.service.studentDetailsService;
import com.auto.exam.service.examService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class studentController {
    private final studentDetailsService studentDetailsService;
    private final examService examService;

    @Autowired
    public studentController(studentDetailsService studentDetailsService, examService examService) {
        this.studentDetailsService = studentDetailsService;
        this.examService = examService;
    }

    @Autowired
    private userRepo userRepo;


    @GetMapping("/getall")
    public ResponseEntity<List<Student>> getStudents(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName()+"---------------------------");
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
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepo.findByUsername(username);
    }

    @PostMapping("/get exams")
    public ResponseEntity<List<Exam>> getExamsOnDate(@RequestBody Date date){
        return null;
    }
}
