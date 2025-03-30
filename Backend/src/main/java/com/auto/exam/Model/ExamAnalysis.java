package com.auto.exam.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "exam_analysis")
public class ExamAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analysis_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(name = "student_answer", nullable = false)
    private String studentAnswer;

    @Column(name = "student_marks")
    private Integer studentMarks;

    public ExamAnalysis() {
    }

    public ExamAnalysis(Exam exam, Question question, String studentAnswer, Integer studentMarks) {
        this.exam = exam;
        this.question = question;
        this.studentAnswer = studentAnswer;
        this.studentMarks = studentMarks;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
    public Integer getStudentMarks() {
        return studentMarks;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }
    public void setStudentMarks(Integer studentMarks) {
        this.studentMarks = studentMarks;
    }
}
