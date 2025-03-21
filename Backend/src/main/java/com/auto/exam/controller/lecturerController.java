package com.auto.exam.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto.exam.Dto.CoursesForLecture;
import com.auto.exam.Dto.ExamAdding;
import com.auto.exam.Model.Course;
import com.auto.exam.Model.Exam;
import com.auto.exam.Dto.ExamRequest;
import com.auto.exam.Model.SendingExam;
import com.auto.exam.service.examService;
import com.auto.exam.Model.CourseOffering;
import com.auto.exam.repo.courseOfferingRepo;

import jakarta.transaction.Transactional;

import com.auto.exam.service.courseService;



@RestController
@CrossOrigin
@RequestMapping("/lecturer")
public class lecturerController {

    private examService examService;
    private courseService courseService;
    private courseOfferingRepo courseOfferingRepo;

    @Autowired
    public lecturerController(examService examService, courseService courseService, courseOfferingRepo courseOfferingRepo) {
        this.courseService = courseService;
        this.examService = examService;
        this.courseOfferingRepo = courseOfferingRepo;
    }
    

    @PostMapping("/getExamsByDate")
    public ResponseEntity<List<SendingExam>> getExamsOnDate_ACLecture(@RequestBody ExamRequest request) {
        List<SendingExam> ex = examService.getExamsUsingDateAndLecture(request);
        return new ResponseEntity<>(ex, HttpStatus.OK); 
    }

    @GetMapping("/getCourses")
    @Transactional
    public ResponseEntity<List<CoursesForLecture>> getCourses() {
        List<CoursesForLecture> courses = courseService.getCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping("/addExam")
    public ResponseEntity<Exam> addExam(@RequestBody Map<String, Object> payload) {
        try {
            Exam savedExam = examService.addExam(payload);
            return new ResponseEntity<>(savedExam, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}