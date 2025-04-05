package com.auto.exam.repo;

import com.auto.exam.Dto.ExamFront;
import com.auto.exam.Dto.MarkEssayQuestion;
import com.auto.exam.Dto.MarkQuestions;
import com.auto.exam.Dto.ShowStudentList;
import com.auto.exam.Model.Exam;
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

    @Query("SELECT DISTINCT new com.auto.exam.Dto.ExamFront(e.examId, e.type, e.startDateTime, c.courseName, c.courseCode) " +
           "FROM ExamAnalysis ea " +
           "JOIN ea.exam e " +
           "JOIN e.courseOffering co " +
           "JOIN co.lecture lec " +
           "JOIN co.course c " +
           "WHERE lec.lectureId = :lecturerId")
    List<ExamFront> getExamByLecturerId(@Param("lecturerId") Long lecturerId);

    @Query("SELECT ea.marked FROM ExamAnalysis ea JOIN ea.exam e WHERE e.examId = :examId")
    boolean findMarkedByExamId(@Param("examId") long examId);

    @Query("SELECT new com.auto.exam.Dto.ShowStudentList(ea.studentId) FROM ExamAnalysis ea ")
    List<ShowStudentList> findStudentByExamId(Long examId);

    @Query("SELECT new com.auto.exam.Dto.MarkEssayQuestion(q.questionId, q.question, ea.studentAnswer, ea.studentMarks) " +
    "FROM ExamAnalysis ea " +
    "JOIN ea.question q " +
    "WHERE ea.exam.examId = :examId AND ea.studentId = :studentId")
    List<MarkEssayQuestion> findQuestionByStudentId(@Param("examId") long examId, @Param("studentId") long studentId);
}
