package com.auto.exam.service;

import com.auto.exam.Model.Exam;
import com.auto.exam.repo.examRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class examService {
    private examRepo examRepo;

    @Autowired
    public examService(examRepo examRepo){
        this.examRepo=examRepo;
    }

    public List<Exam> getExamsUsingDate(String date){
        List<Exam> exams=examRepo.findAll();
//        for(Exam x:exams){
//            System.out.println(x.toString());
//            System.out.println("**************************");
//        }
//        System.out.println(exams);
        return exams;
    }
}
