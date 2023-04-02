package com.example.HospitalManagement;

import org.springframework.stereotype.Service;

@Service
public class nurseService {
    nurseRepository nurseRepositoryObj = new nurseRepository();
    public String add(Nurse nurse){
        return nurseRepositoryObj.add(nurse);
    }
}
