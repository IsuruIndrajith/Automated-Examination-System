package com.auto.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auto.exam.Model.Complain;

public interface complainRepo extends JpaRepository<Complain, Long> {
    
}
