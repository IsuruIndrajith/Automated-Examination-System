
package com.auto.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.auto.exam.Dto.ExamFront;
import com.auto.exam.Dto.MarkEssayQuestion;
import com.auto.exam.Dto.MarkQuestions;
import com.auto.exam.Dto.ShowStudentList;
import com.auto.exam.Model.Exam;
import com.auto.exam.Model.ExamAnalysis;
import com.auto.exam.Model.User;
import com.auto.exam.repo.examanalysisRepo;
import com.auto.exam.repo.userRepo;

@Service
public class examAnalysisService {

    private examanalysisRepo examanalysisRepo;
    private userRepo userRepo;
    @Autowired
    public examAnalysisService(examanalysisRepo examanalysisRepo, userRepo userRepo) {
        this.examanalysisRepo = examanalysisRepo;
        this.userRepo = userRepo;
    }

    public List<ExamFront> returnExams() {
        SecurityContext context = SecurityContextHolder.getContext();
        String username = context.getAuthentication().getName();
        User user = userRepo.findByUsername(username);
        Long LecturerId = user.getId();
        
        List<ExamFront> examFronts = examanalysisRepo.getExamByLecturerId(LecturerId);
        // Filter out exams that are marked
        //if marked is true, remove it from the list
        examFronts.removeIf(exam -> examanalysisRepo.findMarkedByExamId(exam.getId()));

        return examFronts;

    }

    public List<ShowStudentList> ShowStudentList(Long ExamId) {
        

        List<ShowStudentList> studentList = examanalysisRepo.findStudentByExamId(ExamId);


        return studentList;
        
    }

    public List<MarkEssayQuestion> showStudentAnswers(long examId, long studentId) {
        List<MarkEssayQuestion> questions = examanalysisRepo.findQuestionByStudentId(examId,studentId);
        return questions;
    }


}
