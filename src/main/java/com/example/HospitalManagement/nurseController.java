package com.example.HospitalManagement;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nurse")
public class nurseController {

    nurseService nurseServiceObj = new nurseService();
    @PostMapping("/add")
    public String add(Nurse nurse){
        return  nurseServiceObj.add(nurse);
    }

}
