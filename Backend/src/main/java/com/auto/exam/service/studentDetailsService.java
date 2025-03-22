package com.auto.exam.service;

import com.auto.exam.Model.Student;
import com.auto.exam.Model.User;
import com.auto.exam.repo.userRepo;
// import com.auto.exam.service.studentDetailsService;
import com.auto.exam.Model.UserPrincipal;
import com.auto.exam.repo.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentDetailsService {

    private final studentRepo studentRepo;
    private final userRepo userRepo;

    @Autowired
    public studentDetailsService(studentRepo studentRepo, userRepo userRepo){
        this.userRepo=userRepo;
        this.studentRepo=studentRepo;
    }

    public List<Student> get_student(){
        return studentRepo.findAll();
    }

    public Student save_student(Student student) {
        return studentRepo.save(student);
    }

    public Student getStudentByUser(User user) {
        System.out.println("Fetching student for user: " + user);
        Student student = studentRepo.findByUser(user);
        System.out.println("Student fetched: " + student);
        return student;
    }

    public Student getStudentFromUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();        
        User user = userRepo.findByUsername(userPrincipal.getUsername());   
        Student student = getStudentByUser(user);
        return student;
    }
    
}
