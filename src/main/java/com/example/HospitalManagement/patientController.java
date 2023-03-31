package com.example.HospitalManagement;

import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class patientController {

    HashMap<Integer,Patient> patientDb = new HashMap<>();
    @PostMapping("/addPatientViaParam")
    public String addPatient(@RequestParam("patientID")Integer patientId, @RequestParam("name")String name,
                           @RequestParam("Disease")String disease, @RequestParam("age")Integer age){

        Patient patient = new Patient(patientId, name, disease, age);

        patientDb.put(patientId, patient);
        return "Patient registered successfully";
    }

    @PostMapping("/addPatientViaRequestBody")
    public String addPatient(@RequestBody Patient patient){

        int key = patient.getPatientID();
        patientDb.put(key, patient);
        return "Patient registered via Request Body";
    }

    @GetMapping("/getPatientInfo")
    public Patient getPatient(@RequestParam("patientId")Integer patientId){

        Patient patient = patientDb.get(patientId);
        return patient;
    }

    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients(){
        List<Patient> patientList = new ArrayList<>();
        for(int id : patientDb.keySet()){
            patientList.add(patientDb.get(id));
        }
        return patientList;
    }
    @GetMapping("/getPatientByName")
    public Patient getPatient(@RequestParam("name")String name){
        for(int id : patientDb.keySet()){
            if(name == patientDb.get(id).getName())
                return patientDb.get(id);
        }
        return null;
    }

    @GetMapping("/getPatientGreaterThanAge")
    public List<Patient> getPatientGreaterThanAge(@RequestParam("age")Integer age){
        List<Patient> patientList = new ArrayList<>();
        for(Patient patient : patientDb.values()){
            if(patient.getAge() > age) patientList.add(patient);
        }
        return patientList;
    }
}
