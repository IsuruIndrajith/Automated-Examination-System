package com.auto.exam.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "complains")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Complain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complain_id")
    private Long complainId;
    private String title;
    private String category;
    private String description;
    private boolean complainStatus;
    private String complainResponse;
}

// title 
// catergory; su, class, lec, other
// descripton
