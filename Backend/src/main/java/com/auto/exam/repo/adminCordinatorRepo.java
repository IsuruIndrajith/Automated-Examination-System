package com.auto.exam.repo;

import com.auto.exam.Model.AdminCordinator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface adminCordinatorRepo extends JpaRepository<AdminCordinator,Long> {
}
