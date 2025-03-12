package com.auto.exam.repo;

import com.auto.exam.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}