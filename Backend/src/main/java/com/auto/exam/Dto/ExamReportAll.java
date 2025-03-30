package com.auto.exam.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamReportAll {
    private Long studentId;
    private String fullName;
    private Integer marks;
    private Character grade;


}
