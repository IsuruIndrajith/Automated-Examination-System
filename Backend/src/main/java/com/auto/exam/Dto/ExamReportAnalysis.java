package com.auto.exam.Dto;

import com.auto.exam.Model.Question;

public class ExamReportAnalysis {

    private Long examId;
    private Question question;
    private String studentAnswer;

    public ExamReportAnalysis() {
    }

    public ExamReportAnalysis(Long examId, Question question, String studentAnswer) {
        this.examId = examId;
        this.question = question;
        this.studentAnswer = studentAnswer;
    }

    // Getters and Setters
    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
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
}
