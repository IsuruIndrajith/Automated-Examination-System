package com.auto.exam.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ExamReciveQuestion {
    private String question;
    private String answer;
    private int marks;
    private String type;

}