package com.auto.exam.repo;

import com.auto.exam.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface departmentRepo extends JpaRepository<Department, Integer> {
}
