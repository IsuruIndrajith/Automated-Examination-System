package com.auto.exam.repo;

import com.auto.exam.Model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface registraionRepo extends JpaRepository<Registration, Long> {
}
