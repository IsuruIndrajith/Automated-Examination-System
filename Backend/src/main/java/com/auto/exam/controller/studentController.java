package com.auto.exam.controller;

import com.auto.exam.Dto.ExamReport;
import com.auto.exam.Dto.ExamReportAnalysis;
import com.auto.exam.Dto.ExamRequest;
import com.auto.exam.Model.*;
import com.auto.exam.repo.userRepo;
import com.auto.exam.service.studentDetailsService;
import com.auto.exam.service.examService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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
        List<Student> st = studentDetailsService.get_student();
        return new ResponseEntity<>(st, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student newStudent = studentDetailsService.save_student(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @GetMapping("/profile")
    public  User getUserProfile() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepo.findByUsername(username);
    }

    @PostMapping("/getExamsByDate")
    public ResponseEntity<List<SendingExam>> getExamsOnDate(@RequestBody ExamRequest request) {
        List<SendingExam> ex = examService.getExamsUsingDateAndStudent(request);
        return new ResponseEntity<>(ex, HttpStatus.OK); 
    }

    @PostMapping("/exam/{ExamID}")
    public ResponseEntity<List<ProvideQuestion>> examQuestions(@PathVariable long ExamID){
        return new ResponseEntity<>(examService.getQuestions(ExamID),HttpStatus.OK);
    }


    @PostMapping("/exam/{ExamID}/submit")
    public ResponseEntity<List<MarkQuestions>> markQuestions(@RequestBody List<MarkQuestions> markQuestions){
        return new ResponseEntity<>(examService.markQuestions(markQuestions),HttpStatus.ACCEPTED) ;
    }


    @PostMapping("/reports")
    public ResponseEntity<List<ExamReport>> getReports(){
        return new ResponseEntity<>(studentDetailsService.getReports(),HttpStatus.OK) ;
    }

    @PostMapping("/reports/{examId}")
    public ResponseEntity<List<ExamReportAnalysis>> examAnalysis(@PathVariable long examId) {
        List<ExamReportAnalysis> analysisList = studentDetailsService.examAnalysis(examId);
        return new ResponseEntity<>(analysisList, HttpStatus.OK);
    }


}
