package com.auto.exam.Dto;

public class OptionList {

    private Long optionId;
    private String optionText;
    private Boolean isCorrect;

    public OptionList(String optionText) {
      
        this.optionText = optionText;
        
    }



    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }



}
