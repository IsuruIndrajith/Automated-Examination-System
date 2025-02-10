package com.auto.exam.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class student {

    @Id
    private int studentId;
    private String email;
    private String fullName;
    private int nic;
    private int nationality;
    private int photoLink;
    private int address;
    private int gender;
    private String phoneNo;
    private int departmentId;
    private int lectureId;

    public student(int studentId, String email, String fullName, int nic, int nationality, int photoLink, int address, int gender, String phoneNo, int departmentId, int lectureId) {
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

    public student() {
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

    public int getNic() {
        return nic;
    }

    public void setNic(int nic) {
        this.nic = nic;
    }

    public int getNationality() {
        return nationality;
    }

    public void setNationality(int nationality) {
        this.nationality = nationality;
    }

    public int getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(int photoLink) {
        this.photoLink = photoLink;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
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
