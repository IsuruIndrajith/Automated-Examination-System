package com.auto.exam.Model;

import jakarta.persistence.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    private Long examId;

    @Column(name = "start_data_and_time")
    @GetMapping("/profile")
    public String getUserProfile(@AuthenticationPrincipal User user) {
        return "User Profile for: " + user.getUsername();
    }    private LocalDateTime startDateTime;
    private Integer duration;
    private Integer passingCriteria;
    private Integer type;
    private Integer totalMarks;

    @ManyToOne
    @JoinColumn(name = "offering_id")
    private CourseOffering courseOffering;
}

