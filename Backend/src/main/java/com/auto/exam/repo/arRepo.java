package com.auto.exam.repo;

import com.auto.exam.Model.AR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface arRepo extends JpaRepository<AR,Integer> {
}
