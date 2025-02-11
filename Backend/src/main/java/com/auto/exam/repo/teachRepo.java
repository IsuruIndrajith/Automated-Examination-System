package com.auto.exam.repo;

import com.auto.exam.Model.Teach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface teachRepo extends JpaRepository<Teach, Long> {
}
