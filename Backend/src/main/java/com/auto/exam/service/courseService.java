package com.auto.exam.service;

// import java.nio.file.attribute.UserPrincipal;

import java.security.Security;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto.exam.Dto.CoursesForLecture;
import com.auto.exam.Model.Course;
import com.auto.exam.Model.Exam;
import com.auto.exam.Model.UserPrincipal;
import com.auto.exam.repo.courseRepo;
import com.auto.exam.util.SecurityUtil;

@Service
public class courseService {
    private courseRepo courseRepo;

    @Autowired
    public courseService(courseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public List<CoursesForLecture> getCourses() {
        UserPrincipal userPrincipal = SecurityUtil.getAuthenticatedUser();
        List<CoursesForLecture> coursesForLectures= courseRepo.findCourseByLectureName(userPrincipal.getUsername());
        return coursesForLectures; 
    }
}
