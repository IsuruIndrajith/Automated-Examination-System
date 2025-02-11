package com.auto.exam.repo;

import com.auto.exam.Model.Question;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface questionRepo extends JpaRepository<Question, Long> {
}
