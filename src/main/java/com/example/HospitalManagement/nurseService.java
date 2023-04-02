package com.example.HospitalManagement;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class nurseService {
    nurseRepository nurseRepositoryObj = new nurseRepository();
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
