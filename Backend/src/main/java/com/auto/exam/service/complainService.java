package com.auto.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto.exam.Model.Complain;
import com.auto.exam.repo.complainRepo;

@Service
public class complainService {

    private complainRepo complainRepo;

    @Autowired
    public complainService(complainRepo complainRepo) {
        this.complainRepo = complainRepo;
    }

    public void addComplain(Complain complain) {
        complainRepo.save(complain);
    }

    public List<Complain> getAllComplains() {
        return complainRepo.findAll();
    }
    
}
