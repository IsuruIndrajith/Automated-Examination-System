package com.auto.exam.repo;

import com.auto.exam.Model.Attempt;
import com.auto.exam.Dto.ExamReport;
import com.auto.exam.Dto.ExamReportAll;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface attemptRepo extends JpaRepository<Attempt, Long> {
    @Query("SELECT new com.auto.exam.Dto.ExamReport(a.attemptId, e.examId, e.startDateTime, e.totalMarks, a.marks, a.grade, s.studentId, c.courseName) " +
    "FROM Attempt a " +
    "JOIN a.exam e " +
    "JOIN a.student s " +
    "JOIN e.courseOffering co " +
    "JOIN co.course c " +
    "WHERE s.studentId = :studentId")
    List<ExamReport> findExamByStudentId(@Param("studentId") Long studentId);

    @Query("SELECT new com.auto.exam.Dto.ExamReportAll(s.studentId, s.fullName,a.marks, a.grade) "+
        "FROM Attempt a "+
        "JOIN a.exam e "+
        "JOIN a.student s "+
        "WHERE e.examId = :examId")
    List<ExamReportAll> getReports(@Param("examId") Long examId);



}
