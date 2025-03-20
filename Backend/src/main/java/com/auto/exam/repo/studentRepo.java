package com.auto.exam.repo;

import com.auto.exam.Model.Student;
import com.auto.exam.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepo extends JpaRepository<Student, Integer> {

    Student findByUser(User user);
}
