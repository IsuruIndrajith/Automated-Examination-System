package com.project_test1.Automated_exam.Repo;

import com.project_test1.Automated_exam.Model.student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepo extends JpaRepository< student ,Integer> {
}
