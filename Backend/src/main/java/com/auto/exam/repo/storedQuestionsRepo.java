package com.auto.exam.repo;

import com.auto.exam.Model.StoredQuestions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface storedQuestionsRepo extends JpaRepository<StoredQuestions, Long> {
}
