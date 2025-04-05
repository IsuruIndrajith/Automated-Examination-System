package com.auto.exam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto.exam.Dto.Examevent;
import com.auto.exam.service.examService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class adminController {

    private examService examService;

    public adminController(examService examService) {
        this.examService = examService;
    }

    @PostMapping("/getAllExam")
    public ResponseEntity<Examevent> getAllExam(){
        try {
            Examevent reports= examService.getAllExamEvents();
            return new ResponseEntity<>(reports, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    



}