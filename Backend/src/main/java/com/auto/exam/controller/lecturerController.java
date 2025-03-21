package com.auto.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto.exam.Model.Exam;
import com.auto.exam.Model.ExamRequest;
import com.auto.exam.Model.SendingExam;
import com.auto.exam.service.examService;


@RestController
@CrossOrigin
@RequestMapping("/lecturer")
public class lecturerController {

    private examService examService;

    @Autowired
    public lecturerController(examService examService) {
        this.examService = examService;
    }
    

    @PostMapping("/getExamsByDate")
    public ResponseEntity<List<SendingExam>> getExamsOnDate_ACLecture(@RequestBody ExamRequest request) {
        List<SendingExam> ex = examService.getExamsUsingDateAndLecture(request);
        return new ResponseEntity<>(ex, HttpStatus.OK); 
    }
}