package com.auto.exam.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Entity
@Table(name = "exam")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    private Long examId;
    @Column(name = "start_date_and_time") // Fixed typo in column name
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Helps with JSON serialization
    private LocalDateTime startDateTime;
    private Integer duration;
    private Integer passingCriteria;
    private Integer type;
    private Integer totalMarks;

    @ManyToOne
    @JoinColumn(name = "offering_id")
    private CourseOffering courseOffering;

    //    @Column(name = "start_data_and_time")
//    @GetMapping("/profile")
//    public String getUserProfile(@AuthenticationPrincipal User user) {
//        return "User Profile for: " + user.getUsername();
//    }
//    private LocalDateTime startDateTime;
    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", startDateTime=" + startDateTime +
                ", duration=" + duration +
                ", passingCriteria=" + passingCriteria +
                ", type=" + type +
                ", totalMarks=" + totalMarks +
                ", courseOffering=" + courseOffering +
                '}';
    }


}

