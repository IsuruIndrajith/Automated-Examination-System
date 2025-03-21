package com.auto.exam.Dto;

import com.auto.exam.Model.Exam;

public class ExamReport {
    private Long attemptId;
    private Exam exam;
    private Integer marks;
    private Character grade;
    private Long studentId;

    public ExamReport(Long attemptId, Exam exam, Integer marks, Character grade, Long studentId) {
        this.attemptId = attemptId;
        this.exam = exam;
        this.marks = marks;
        this.grade = grade;
        this.studentId = studentId;
    }

    // Getters and Setters
    public Long getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(Long attemptId) {
        this.attemptId = attemptId;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
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
}
