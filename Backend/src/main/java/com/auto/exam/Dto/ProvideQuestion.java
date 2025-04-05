package com.auto.exam.Dto;

import java.util.List;

import com.auto.exam.Model.McqOptions;

public class ProvideQuestion {
    private long questionId;
    private String question;
    private Integer marks;
    private List<OptionList> OptionList;

    public ProvideQuestion(long questionId, String question, Integer marks, List<OptionList> OptionList) {
        this.questionId = questionId;
        this.question = question;
        this.marks = marks;
        this.OptionList = OptionList;
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
    public List<OptionList> getOptionList() {
        return OptionList;
    }
    public void setOptionList(List<OptionList> OptionList) {
        this.OptionList = OptionList;
    }
}
