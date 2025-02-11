package com.auto.exam.repo;

import com.auto.exam.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface departmentRepo extends JpaRepository<Department, Integer> {
}
