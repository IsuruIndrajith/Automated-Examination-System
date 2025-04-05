package com.auto.exam.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkEssayQuestion {

    private Long questionId;
    private String question;
    private String studentAnswer;
    private Integer marks;

}
