package com.auto.exam.Dto;

import java.time.LocalDateTime;

public class ExamReport {
    private Long attemptId;
    private long examId;
    private LocalDateTime startDateTime;
    private Integer totalMarks;
    private Integer marks;
    private Character grade;
    private Long studentId;
    private String courseName;

    public ExamReport(Long attemptId, long examId, LocalDateTime startDateTime, Integer totalMarks, Integer marks, Character grade, Long studentId, String courseName) {
        this.attemptId = attemptId;
        this.examId = examId;
        this.startDateTime = startDateTime;
        this.totalMarks = totalMarks;
        this.marks = marks;
        this.grade = grade;
        this.studentId = studentId;
        this.courseName = courseName;
    }

    public Long getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(Long attemptId) {
        this.attemptId = attemptId;
    }

    public long getExamId() {
        return examId;
    }

    public void setExamId(long examId) {
        this.examId = examId;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Integer getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public Character getGrade() {
        return grade;
    }

    public void setGrade(Character grade) {
        this.grade = grade;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}