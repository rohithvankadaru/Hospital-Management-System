package com.example.HospitalManagement.Service;

import com.example.HospitalManagement.Models.Nurse;
import com.example.HospitalManagement.Repository.nurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class nurseService {

    @Autowired
     nurseRepository nurseRepositoryObj;
    public String add(Nurse nurse){
        String msg = nurseRepositoryObj.add(nurse);
        return msg;
    }
    public String update(int id, int age){
        return nurseRepositoryObj.update(id, age);
    }

    public List<Nurse> getAll(){
        List<Nurse> all =  nurseRepositoryObj.getAll();
        return all;
    }
}
