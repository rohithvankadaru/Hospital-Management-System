package com.example.HospitalManagement;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    HashMap<Integer,Doctor> doctorDb = new HashMap<>();
    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){
        int key = doctor.getDoctorID();
        doctorDb.put(key, doctor);
        return "successfully doctor added";
    }

    @GetMapping("/get")
    public Doctor getDoctor(@RequestParam("doctorID")Integer doctorID){
        if(doctorDb.containsKey(doctorID)) return doctorDb.get(doctorID);
        return null;
    }
}
