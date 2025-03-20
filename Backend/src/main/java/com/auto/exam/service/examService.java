package com.auto.exam.service;

import com.auto.exam.Model.*;
import com.auto.exam.repo.courseRegisterRepo;
import com.auto.exam.repo.examRepo;
import com.auto.exam.repo.questionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private questionRepo questionRepo;

    @Autowired
    public examService(examRepo examRepo, courseRegisterRepo courseRegisterRepo,questionRepo questionRepo){
        this.examRepo=examRepo;
        this.courseRegisterRepo=courseRegisterRepo;
        this.questionRepo = questionRepo;
    }

    public List<Exam> getExamsUsingDate(Date date, Student student){
        Date date1 =new  Date(2025,6,21, 9,0,0); //2025-06-21 09:00:00
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        
        Long id=student.getStudentId();
        
        List<Exam> exams = examRepo.findExamAllCustom1(id);

        return exams.stream().filter(exam -> exam.getStartDateTime().toString().equals(outputFormat.format(date1))).toList();

    }
    public List<ProvideQuestion> getQuestions(long examID) {

     /*   Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        String user  = userRepo.findByUsername(userPrincipal.getUsername());
        Student student = studentRepo.findByUser(user.getUsername());
        */


        return questionRepo.findQuestionById(examID).stream()
                .map(q -> new ProvideQuestion(q.getQuestionId(), q.getQuestion(), q.getMarks()))
                .collect(Collectors.toList());
    }
    @Transactional
    public List<MarkQuestions> markQuestions(List<MarkQuestions> markQuestions) {
        for (MarkQuestions question : markQuestions) {

            String correctAnswer = questionRepo.findAnswerByQuestionId((long) question.getQuestionId());
            int retrievedMarks = questionRepo.findMarksByQuestionId((long) question.getQuestionId());

            // Compare the given answer with the correct answer
            if (question.getAnswer().equalsIgnoreCase(correctAnswer)) {
                question.setMarks(retrievedMarks); // Full marks for correct answer
            } else {
                question.setMarks(0); // Assign 0 marks for incorrect answers
            }
        }
        return markQuestions;
    }
}
