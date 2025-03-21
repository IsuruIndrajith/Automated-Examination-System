package com.auto.exam.Dto;

public class MarkQuestions {
    private int QuestionId;
    private String Answer ;
    private int Marks;

    public MarkQuestions(int questionId, String answer, int marks) {
        QuestionId = questionId;
        Answer = answer;
        Marks = marks;
    }

    public int getQuestionId() {
        return QuestionId;
    }

    public void setQuestionId(int questionId) {
        QuestionId = questionId;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public int getMarks() {
        return Marks;
    }

    public void setMarks(int marks) {
        Marks = marks;
    }
}
