package com.auto.exam.service;

import com.auto.exam.Model.*;
import com.auto.exam.repo.*;

import org.springframework.security.core.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class examService {
    private examRepo examRepo;
    private courseRegisterRepo courseRegisterRepo;
    private userRepo userRepo;
    private studentDetailsService studentDetailsService;
    private questionRepo questionRepo;
    private attemptRepo attemptRepo;
    private studentRepo studentRepo;

    private long ExamId;
  
    @Autowired
    public examService(examRepo examRepo, courseRegisterRepo courseRegisterRepo,questionRepo questionRepo,userRepo userRepo,studentDetailsService studentDetailsService,attemptRepo attemptRepo,studentRepo studentRepo){
        this.examRepo=examRepo;
        this.courseRegisterRepo=courseRegisterRepo;
        this.questionRepo = questionRepo;
        this.userRepo = userRepo;
        this.studentDetailsService = studentDetailsService;
        this.attemptRepo = attemptRepo;
        this.studentRepo = studentRepo;
    }
    

    public List<Exam> getExamsUsingDate(ExamRequest request){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();        

        Date date;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = formatter.parse(request.getDate());
        } catch (ParseException e) {
            return null;
        }
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        String user_name = userPrincipal.getUsername();
        List<Exam> exams = examRepo.findExamByUser(user_name);
        return exams.stream().filter(exam -> exam.getStartDateTime().toString().equals(outputFormat.format(date))).toList();

    }
    public List<ProvideQuestion> getQuestions(long examID) {

     /*   Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        String user  = userRepo.findByUsername(userPrincipal.getUsername());
        Student student = studentRepo.findByUser(user.getUsername());
        */

        this.ExamId=examID;
        return questionRepo.findQuestionById(examID).stream()
                .map(q -> new ProvideQuestion(q.getQuestionId(), q.getQuestion(), q.getMarks()))
                .collect(Collectors.toList());
    }
    @Transactional
    public List<MarkQuestions> markQuestions(List<MarkQuestions> markQuestions) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        int TotalMarks = 0;
        Attempt attempt = new Attempt();
        for (MarkQuestions question : markQuestions) {

            String correctAnswer = questionRepo.findAnswerByQuestionId((long) question.getQuestionId());
            int retrievedMarks = questionRepo.findMarksByQuestionId((long) question.getQuestionId());

            // Compare the given answer with the correct answer
            if (question.getAnswer().equalsIgnoreCase(correctAnswer)) {
                question.setMarks(retrievedMarks); // Full marks for correct answer
            } else {
                question.setMarks(0); // Assign 0 marks for incorrect answers
            }
            TotalMarks = TotalMarks+question.getMarks();
        }
        attempt.setMarks(TotalMarks);

        Exam exam =  examRepo.findExamByExamId(ExamId);
        User user = userRepo.findByUsername(userPrincipal.getUsername());

        attempt.setExam(exam);
        attempt.setGrade(getGrade(TotalMarks));

        Student student = studentRepo.findByUser(user);

        attempt.setStudent(student);
        try {
            attemptRepo.save(attempt);
        }
        catch (Exception e){
            System.out.println("Cannot Attempt More Than One Time "+e);
           // return "Cannot Attempt More Than One Time";
        }
        return markQuestions;
    }

    public Character getGrade(int totalMarks) {
        if (totalMarks >= 90) return 'A';
        else if (totalMarks >= 80) return 'B';
        else if (totalMarks >= 70) return 'C';
        else if (totalMarks >= 60) return 'D';
        else if (totalMarks >= 50) return 'E';
        else return 'F';
    }
}
