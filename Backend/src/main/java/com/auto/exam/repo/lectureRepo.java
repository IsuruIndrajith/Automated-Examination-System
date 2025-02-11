package com.auto.exam.repo;

import com.auto.exam.Model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface lectureRepo extends JpaRepository<Lecture, Long> {
}
