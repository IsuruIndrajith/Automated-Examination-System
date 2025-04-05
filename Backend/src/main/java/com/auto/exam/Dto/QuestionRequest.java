package com.auto.exam.Dto;

public class QuestionRequest {
    private String question;

    QuestionRequest(String question) {
        this.question = question;
    }

    QuestionRequest() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
