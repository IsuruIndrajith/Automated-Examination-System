package com.auto.exam.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ExamFront {
    private Long id;
    private Integer type;
    private LocalDateTime date;
    private String subject;
    private String code;
}
