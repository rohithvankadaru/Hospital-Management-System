package com.example.HospitalManagement.Controller;

import com.example.HospitalManagement.Models.Nurse;
import com.example.HospitalManagement.Service.nurseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurse")
public class nurseController {

    nurseService nurseServiceObj = new nurseService();
    @PostMapping("/add")
    public String add(@RequestBody Nurse nurse){
       String msg = nurseServiceObj.add(nurse);
        return msg;
    }

    @PutMapping("/update")
    public String update(@RequestParam("nurseID") Integer nurseID, @RequestParam("age") Integer age){
        return nurseServiceObj.update(nurseID, age);
    }

    @GetMapping("/getAll")
    public List<Nurse> getAll(){
        List<Nurse> all=  nurseServiceObj.getAll();
        return all;
    }

}
