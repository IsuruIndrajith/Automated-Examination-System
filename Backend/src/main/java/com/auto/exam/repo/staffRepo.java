package com.auto.exam.repo;

import com.auto.exam.Model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface staffRepo extends JpaRepository<Staff, Long> {
}
