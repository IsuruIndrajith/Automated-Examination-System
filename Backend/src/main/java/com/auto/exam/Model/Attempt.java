package com.auto.exam.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "attempt", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"student_id", "exam_id"})
})
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attempt_id")
    private Long attemptId;

    @ManyToOne
    @JoinColumn(name = "student_id",nullable = false)
    private Student student;


    @ManyToOne
    @JoinColumn(name = "exam_id",nullable = false)
    private Exam exam;

    private Integer marks;
    private Character grade;

    public Attempt(Long attemptId, Student student, Integer marks, Exam exam, Character grade) {
        this.attemptId = attemptId;
        this.student = student;
        this.marks = marks;
        this.exam = exam;
        this.grade = grade;
    }

    public Attempt() {
    }

    public Long getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(Long attemptId) {
        this.attemptId = attemptId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
}
