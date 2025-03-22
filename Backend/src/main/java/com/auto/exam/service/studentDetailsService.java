package com.auto.exam.service;

import com.auto.exam.Dto.ExamReport;
import com.auto.exam.Dto.ExamReportAnalysis;
import com.auto.exam.Model.*;
import com.auto.exam.repo.attemptRepo;
import com.auto.exam.repo.examanalysisRepo;
import com.auto.exam.repo.userRepo;
// import com.auto.exam.service.studentDetailsService;
import com.auto.exam.repo.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class studentDetailsService {

    private final studentRepo studentRepo;
    private final userRepo userRepo;
    private final attemptRepo attemptRepo;
    private final examanalysisRepo examanalysisRepo;

    @Autowired
    public studentDetailsService(studentRepo studentRepo, userRepo userRepo, com.auto.exam.repo.attemptRepo attemptRepo, com.auto.exam.repo.examanalysisRepo examanalysisRepo){
        this.userRepo=userRepo;
        this.studentRepo=studentRepo;
        this.attemptRepo = attemptRepo;
        this.examanalysisRepo = examanalysisRepo;
    }

    public List<Student> get_student(){
        return studentRepo.findAll();
    }

    public Student save_student(Student student) {
        return studentRepo.save(student);
    }

    public Student getStudentByUser(User user) {
        System.out.println("Fetching student for user: " + user);
        Student student = studentRepo.findByUser(user);
        System.out.println("Student fetched: " + student);
        return student;
    }

    public Student getStudentFromUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();        
        User user = userRepo.findByUsername(userPrincipal.getUsername());   
        Student student = getStudentByUser(user);
        return student;
    }

    public List<ExamReport> getReports() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        User user = userRepo.findByUsername(userPrincipal.getUsername());
        Student student = getStudentByUser(user);
        return attemptRepo.findExamByStudentId(student.getStudentId());
    }

    public List<ExamReportAnalysis> examAnalysis(long examId) {
        List<ExamAnalysis> examAnalysisList = examanalysisRepo.findByExamId(examId);

        return examAnalysisList.stream()
                .map(exam -> new ExamReportAnalysis(
                        exam.getExam().getExamId(),  // Extract exam ID
                        exam.getQuestion().getQuestionId(),
                        exam.getQuestion().getQuestion(),
                        exam.getQuestion().getMarks(),
                        exam.getQuestion().getAnswer(),// Extract question object
                        exam.getStudentAnswer()      // Extract student's answer
                ))
                .collect(Collectors.toList());
    }

}
