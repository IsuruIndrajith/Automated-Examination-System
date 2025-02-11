package com.auto.exam.repo;

import com.auto.exam.Model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface examRepo extends JpaRepository<Exam, Integer> {
}
