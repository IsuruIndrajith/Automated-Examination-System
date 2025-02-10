package com.auto.exam.Model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Student_ID")
    private int studentId;

    @Column(name = "Email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "Full_Name", nullable = false, length = 255)
    private String fullName;

    @Column(name = "NIC", nullable = false, unique = true, length = 15)
    private String nic;

    @Column(name = "Nationality", nullable = false, length = 50)
    private String nationality;

    @Column(name = "Photo_Link")
    private String photoLink;

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "Gender", nullable = false, length = 10)
    private String gender;

    @Column(name = "Phone_No", nullable = false, length = 20)
    private String phoneNo;

    @Column(name = "Department_ID", nullable = false)
    private int departmentId;

    @Column(name = "Lecture_ID", nullable = false)
    private int lectureId;

    public student() {
    }

    public student(int studentId, String email, String fullName, String nic, String nationality, String photoLink, String address, String gender, String phoneNo, int departmentId, int lectureId) {
        this.studentId = studentId;
        this.email = email;
        this.fullName = fullName;
        this.nic = nic;
        this.nationality = nationality;
        this.photoLink = photoLink;
        this.address = address;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.departmentId = departmentId;
        this.lectureId = lectureId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }
}
