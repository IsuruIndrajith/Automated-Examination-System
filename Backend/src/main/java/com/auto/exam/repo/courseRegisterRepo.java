package com.auto.exam.repo;

import com.auto.exam.Model.CourseRegister;
import com.auto.exam.Model.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface courseRegisterRepo extends JpaRepository<CourseRegister, Long> {
}
