package com.auto.exam.repo;

import com.auto.exam.Model.CourseRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface courseRegisterRepo extends JpaRepository<CourseRegister, Long> {
}
