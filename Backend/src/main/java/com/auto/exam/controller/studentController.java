package com.auto.exam.controller;

import com.auto.exam.Dto.*;
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

    @GetMapping("/profile")
    public  User getUserProfile() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepo.findByUsername(username);
    }

    @PostMapping("/exam/getAll")
    public ResponseEntity<List<SendingExam>> getAllExams() {
        List<SendingExam> ex = examService.getAllExams();
        try {
            return new ResponseEntity<>(ex, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    // {
    //     "examId": 1,
    //     "startDateTime": "2025-06-01T09:00:00",
    //     "duration": 60,
    //     "passingCriteria": 50,
    //     "type": 1,
    //     "totalMarks": 100,
    //     "courseId": 1,
    //     "courseName": "Introduction to CS",
    //     "courseCode": "CS101"
    // },

    @PostMapping("/getExamsByDate")
    public ResponseEntity<List<SendingExam>> getExamsOnDate(@RequestBody ExamRequest request) {
        List<SendingExam> ex = examService.getExamsUsingDateAndStudent(request);
        return new ResponseEntity<>(ex, HttpStatus.OK); 
    }

    @PostMapping("/exam/{ExamID}")
    public ResponseEntity<List<ProvideQuestion>> examQuestions(@PathVariable long ExamID){
        try {
            return new ResponseEntity<>(examService.getQuestions(ExamID),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
    }

//     [
//     {
//         "questionId": 1,
//         "question": "Question1",
//         "marks": 10
//     }
// ]


    @PostMapping("/exam/{ExamID}/submit")
    public ResponseEntity<List<MarkQuestions>> markQuestions(@RequestBody List<MarkQuestions> markQuestions){
        try {
            return new ResponseEntity<>(examService.markQuestions(markQuestions),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


    @PostMapping("/reports")
    public ResponseEntity<List<ExamReport>> getReports(){
        try {
            List<ExamReport> reports = studentDetailsService.getReports();
            return new ResponseEntity<>(reports, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/reports/{examId}")
    public ResponseEntity<List<ExamReportAnalysis>> examAnalysis(@PathVariable long examId) {
        List<ExamReportAnalysis> analysisList = studentDetailsService.examAnalysis(examId);
        try {
            return new ResponseEntity<>(analysisList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
