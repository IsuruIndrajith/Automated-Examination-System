package com.auto.exam.repo;

import com.auto.exam.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface courseRepo extends JpaRepository<Course,Long> {
}
