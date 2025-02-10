package com.auto.exam.service;

import com.auto.exam.Model.student;
import com.auto.exam.repo.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentDetailsService {
    private final studentRepo studentRepo;

    @Autowired
    public studentDetailsService(studentRepo studentRepo){
        this.studentRepo=studentRepo;
    }

    public List<student> get_student(){
        List<student> st=studentRepo.findAll();
        return st;
    }
}
