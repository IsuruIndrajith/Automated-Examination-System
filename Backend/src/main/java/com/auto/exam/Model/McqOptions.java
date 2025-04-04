package com.auto.exam.Model;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mcq_options")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class McqOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Long optionId;

    private String optionText;
    private Integer location;
    private Boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
