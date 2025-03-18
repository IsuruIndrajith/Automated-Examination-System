package com.auto.exam.service;

import com.auto.exam.Model.Exam;
import com.auto.exam.repo.examRepo;

import java.util.List;

public class examService {
    private examRepo examRepo;

    public examService(examRepo examRepo){
        this.examRepo=examRepo;
    }

    public List<Exam> getExamsUsingDate(){
        return examRepo.findAll();
    }
}
