package com.auto.exam.repo;

import com.auto.exam.Model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface lectureRepo extends JpaRepository<Lecture, Long> {
}
