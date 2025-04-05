package com.auto.exam.repo;

import com.auto.exam.Model.ExamAnalysis;
import com.auto.exam.Model.Question;
import com.auto.exam.Model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface examanalysisRepo extends JpaRepository<ExamAnalysis,Long> {

    @Query("SELECT ea FROM ExamAnalysis ea WHERE ea.exam.examId = :examId")
    List<ExamAnalysis> findByExamId(@Param("examId") long examId);

    @Query("SELECT CASE WHEN COUNT(ea) > 0 THEN true ELSE false END " +
    "FROM ExamAnalysis ea " +
    "WHERE ea.studentId = :student AND ea.question.id = :question")
    boolean existsByStudentAndQuestion(@Param("student") Long student, @Param("question") int question);
}
