package com.auto.exam.Dto;

import java.time.LocalDateTime;
import java.util.List;

import com.auto.exam.Model.Question;

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
public class ExamSave {
    private LocalDateTime startDateTime;
    private Integer duration;
    private Integer passingCriteria;
    private Integer type;
    private Integer totalMarks;// Topic of the question
    private Long courseOfferingId;// Topic of the question
    private List<Question> questions;// Topic of the question
}
