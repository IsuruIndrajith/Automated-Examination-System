package com.auto.exam.repo;

import com.auto.exam.Model.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface attemptRepo extends JpaRepository<Attempt, Long> {
}
