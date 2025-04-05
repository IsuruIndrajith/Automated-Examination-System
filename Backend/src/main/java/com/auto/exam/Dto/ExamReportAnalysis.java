package com.auto.exam.Dto;

import com.auto.exam.Model.Question;

public class ExamReportAnalysis {

    private Long examId;
    private Long questionId;
    private String question;
    private Integer marks;
    private String answer;
    private String studentAnswer;
    private Long studentId;


    public ExamReportAnalysis() {
    }
    public ExamReportAnalysis(Long examId, Long questionId, String question, Integer marks, String answer, String studentAnswer, Long studentId) {
        this.examId = examId;
        this.questionId = questionId;
        this.question = question;
        this.marks = marks;
        this.answer = answer;
        this.studentAnswer = studentAnswer;
        this.studentId = studentId;

    }
    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }
    public Long getStudentId() {
        return studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }


}
