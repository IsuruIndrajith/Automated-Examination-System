package com.auto.exam.controller;

import com.auto.exam.Model.Staff;
import com.auto.exam.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.auto.exam.service.staffService;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("staff")
public class staffController {
    private staffService staffService;
    @Autowired
    public staffController(staffService staffService){
        this.staffService=staffService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Staff>> getAll(){
        List<Staff> st=staffService.getAll();
//        System.out.println(st);
        return new ResponseEntity<>(st,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Staff> addStaff(@RequestBody Staff staff) {
        Staff newStaff = staffService.save_staff(staff);
        System.out.println(newStaff.toString());
        return new ResponseEntity<>(newStaff, HttpStatus.CREATED);
    }

}
