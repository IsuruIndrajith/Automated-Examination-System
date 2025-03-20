package com.auto.exam.Model;

public class ProvideQuestion {
    private long questionId;
    private String question;
    private Integer marks;

    public ProvideQuestion(long questionId, String question, Integer marks) {
        this.questionId = questionId;
        this.question = question;
        this.marks = marks;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }
}
