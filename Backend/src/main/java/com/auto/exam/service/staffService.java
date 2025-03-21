package com.auto.exam.service;

import com.auto.exam.Model.Staff;
import com.auto.exam.Model.Student;
import com.auto.exam.repo.staffRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class staffService {
    private staffRepo staffRepo;

    public staffService(staffRepo staffRepo){
        this.staffRepo=staffRepo;
    }

    public List<Staff> getAll(){
        return staffRepo.findAll();
    }

    public Staff save_staff(Staff staff) {
        return staffRepo.save(staff);
    }
}
