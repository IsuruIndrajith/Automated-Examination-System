package com.auto.exam.service;

import com.auto.exam.Model.CourseRegister;
import com.auto.exam.Model.Exam;
import com.auto.exam.Model.Student;
import com.auto.exam.repo.courseRegisterRepo;
import com.auto.exam.repo.examRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class examService {
    private examRepo examRepo;
    private courseRegisterRepo courseRegisterRepo;

    @Autowired
    public examService(examRepo examRepo, courseRegisterRepo courseRegisterRepo){
        this.examRepo=examRepo;
        this.courseRegisterRepo=courseRegisterRepo;
    }

    public List<Exam> getExamsUsingDate(Date date, Student student){
        Date date1 =new  Date(2025,6,21, 9,0,0); //2025-06-21 09:00:00
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        
        Long id=student.getStudentId();
        
        List<Exam> exams = examRepo.findExamAllCustom1(id);

        return exams.stream().filter(exam -> exam.getStartDateTime().toString().equals(outputFormat.format(date1))).toList();

    }
}
