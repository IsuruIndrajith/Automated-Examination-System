package com.auto.exam.repo;

import com.auto.exam.Model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface staffRepo extends JpaRepository<Staff, Long> {
}
