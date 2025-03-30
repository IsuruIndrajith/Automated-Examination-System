package com.auto.exam.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
// @NoArgsConstructor
@Getter
@Setter
public class ExamFront {
    private Long examId;
    private String examName;
    private LocalDateTime startDateTime;

    public ExamFront(Long examId, String examName, LocalDateTime startDateTime) {
        this.examId = examId;
        this.examName = examName;
        this.startDateTime = startDateTime;

    }

    public ExamFront() {
    }
}
