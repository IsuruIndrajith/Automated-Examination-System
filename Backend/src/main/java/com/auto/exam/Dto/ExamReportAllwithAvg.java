package com.auto.exam.Dto;

import java.util.List;
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
public class ExamReportAllwithAvg {
    private Double averageMarks;
    private Double highestMarks;
    private Double lowestMarks;
    private Integer totalStudents;

    private List<ExamReportAll> getAllReports;
    


}
