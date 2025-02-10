package com.auto.exam.repo;

import com.auto.exam.Model.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepo extends JpaRepository<student, Integer> {
}
