package com.auto.exam.repo;

import com.auto.exam.Model.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courseOfferingRepo extends JpaRepository<CourseOffering, Long> {
}
