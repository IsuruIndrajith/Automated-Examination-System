package com.auto.exam.repo;

import com.auto.exam.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courseRepo extends JpaRepository<Course,Long> {
}
