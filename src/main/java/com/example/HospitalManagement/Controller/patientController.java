package com.example.HospitalManagement.Controller;

import com.example.HospitalManagement.Models.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class patientController {

    HashMap<Integer, Patient> patientDb = new HashMap<>();
    @PostMapping("/addViaParam")
    public String addPatient(@RequestParam("patientID")Integer patientId, @RequestParam("name")String name,
                           @RequestParam("disease")String disease, @RequestParam("age")Integer age){

        Patient patient = new Patient(patientId, name, disease, age);

        patientDb.put(patientId, patient);
        return "Patient registered successfully";
    }

    @PostMapping("/addViaRequestBody")
    public String addPatient(@RequestBody Patient patient){

        int key = patient.getPatientID();
        patientDb.put(key, patient);
        return "Patient registered via Request Body";
    }

    @GetMapping("/getViaPath/{patientId}")
    public Patient getpatientViaPath(@PathVariable("patientId") Integer patientId){
        Patient patient = patientDb.get(patientId);

        return patient;
    }

    @GetMapping("/getInfo")
    public Patient getPatient(@RequestParam("patientId")Integer patientId){

        Patient patient = patientDb.get(patientId);
        return patient;
    }

    @GetMapping("/getAll")
    public List<Patient> getAllPatients(){
        List<Patient> patientList = new ArrayList<>();
        for(int id : patientDb.keySet()){
            patientList.add(patientDb.get(id));
        }
        return patientList;
    }
    @GetMapping("/getByName")
    public Patient getPatient(@RequestParam("name")String name){
        for(int id : patientDb.keySet()){
            if(name == patientDb.get(id).getName())
                return patientDb.get(id);
        }
        return null;
    }

    @GetMapping("/getGreaterThanAge")
    public List<Patient> getPatientGreaterThanAge(@RequestParam("age")Integer age){
        List<Patient> patientList = new ArrayList<>();
        for(Patient patient : patientDb.values()){
            if(patient.getAge() > age) patientList.add(patient);
        }
        return patientList;
    }

    @GetMapping("/ViaAgeNDisease/{age}/{Disease}")
    public List<Patient> getPatientViaAgeNDisease(@PathVariable("age")Integer age, @PathVariable("Disease")String Disease){
        List<Patient> patients = new ArrayList<>();
        for(Patient patient : patientDb.values()){
            if(patient.getAge() > age && patient.getDisease() == "cold") patients.add(patient);
        }
        return patients;
    }

    @PutMapping("/updatePatientDetails")
    public String updatePatient(@RequestBody Patient patient){
        int key = patient.getPatientID();
        if(patientDb.containsKey(key)){
            patientDb.put(key, patient);
            return "patient updation successful";
        }
     return "no such patient";
    }

    @PutMapping("/updateDisease")
    public String updateDisease(@RequestParam("patientID")Integer patientID, @RequestParam("disease")String disease){
        Patient p = patientDb.get(patientID);
        if(patientDb.containsKey(patientID)){
            p.setDisease(disease);
            patientDb.put(patientID, p);
            return "updation successful";
        }
        return "no such patient";
    }

    @DeleteMapping("/deletePatient/{PatientId}")
    public String deletePatient(@PathVariable("patientId")Integer patientId){

        patientDb.remove(patientId);

        return "deletion successful";
    }
}