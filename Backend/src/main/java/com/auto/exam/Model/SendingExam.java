package com.auto.exam.Model;

import java.time.LocalDateTime;

public class SendingExam {
    private Long examId;
    private LocalDateTime startDateTime;
    private Integer duration;
    private Integer passingCriteria;
    private Integer type;
    private Integer totalMarks;
    private Long courseId;
    private String courseName;
    private String courseCode;


    public Long getExamId() {
        return this.examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public LocalDateTime getStartDateTime() {
        return this.startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getPassingCriteria() {
        return this.passingCriteria;
    }

    public void setPassingCriteria(Integer passingCriteria) {
        this.passingCriteria = passingCriteria;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTotalMarks() {
        return this.totalMarks;
    }

    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
    }

    public Long getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public SendingExam(Long examId, LocalDateTime startDateTime, Integer duration, Integer passingCriteria, Integer type, Integer totalMarks, Long courseId, String courseName, String courseCode) {
        this.examId = examId;
        this.startDateTime = startDateTime;
        this.duration = duration;
        this.passingCriteria = passingCriteria;
        this.type = type;
        this.totalMarks = totalMarks;
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public SendingExam() {
    }

    

    
}
