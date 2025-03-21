package com.auto.exam.repo;

import com.auto.exam.Model.ExamAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface examanalysisRepo extends JpaRepository<ExamAnalysis,Long> {

    @Query("SELECT ea FROM ExamAnalysis ea WHERE ea.exam.examId = :examId")
    List<ExamAnalysis> findByExamId(@Param("examId") long examId);
}
