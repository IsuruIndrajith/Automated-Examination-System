package com.auto.exam.Dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamAdding {
    private Long offeringId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Helps with JSON serialization
    private LocalDateTime startDateTime;
    private Integer duration;
    private Integer passingCriteria;
    private Integer type;
    private Integer totalMarks;
}
