package com.auto.exam.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Long registrationId;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @Column(nullable = false)
    private Integer semester;


//    @Column(nullable = false)
//    private Integer status;

    @ManyToOne
    @JoinColumn(name = "ar_id", nullable = false)
    private AR ar;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public Registration() {
    }

    public Registration(Long registrationId, LocalDate registrationDate, Integer semester, AR ar, Student student) {
        this.registrationId = registrationId;
        this.registrationDate = registrationDate;
        this.semester = semester;
        this.ar = ar;
        this.student = student;
    }

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public AR getAr() {
        return ar;
    }

    public void setAr(AR ar) {
        this.ar = ar;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
// Constructors, getters, and setters
}
