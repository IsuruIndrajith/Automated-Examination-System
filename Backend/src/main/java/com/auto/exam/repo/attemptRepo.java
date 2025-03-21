package com.auto.exam.repo;

import com.auto.exam.Model.Attempt;
import com.auto.exam.Dto.ExamReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface attemptRepo extends JpaRepository<Attempt, Long> {
    @Query("SELECT new com.auto.exam.Dto.ExamReport(a.attemptId, a.exam, a.marks, a.grade, a.student.studentId) " +
            "FROM Attempt a WHERE a.student.studentId = :studentId")
    List<ExamReport> findExamByStudentId(@Param("studentId") Long studentId);

}
