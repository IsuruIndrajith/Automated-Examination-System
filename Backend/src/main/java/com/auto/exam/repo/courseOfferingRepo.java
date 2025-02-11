package com.auto.exam.repo;

import com.auto.exam.Model.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface courseOfferingRepo extends JpaRepository<CourseOffering, Long> {
}
