package com.auto.exam.service;

import com.auto.exam.Model.*;
import com.auto.exam.repo.examRepo;
import com.auto.exam.repo.questionRepo;
import com.auto.exam.repo.studentRepo;
import com.auto.exam.repo.userRepo;
import jakarta.transaction.Transactional;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class examService {

    private final examRepo examRepo;
    private final questionRepo questionRepo;
    private final studentRepo studentRepo;
    private final userRepo userRepo;

    @Autowired
    public examService(examRepo examRepo , questionRepo questionRepo, com.auto.exam.repo.studentRepo studentRepo, com.auto.exam.repo.userRepo userRepo){
        this.examRepo=examRepo;
        this.questionRepo=questionRepo;
        this.studentRepo = studentRepo;
        this.userRepo = userRepo;
    }

    public List<Exam> getExamsUsingDate(String date){

        return examRepo.findAll();
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
