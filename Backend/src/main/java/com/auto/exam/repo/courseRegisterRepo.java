package com.auto.exam.repo;

import com.auto.exam.Model.CourseRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courseRegisterRepo extends JpaRepository<CourseRegister, Long> {
}
