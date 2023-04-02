package com.example.HospitalManagement;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class nurseRepository {
    HashMap<Integer, Nurse> nurseDb = new HashMap<>();

    public String add(Nurse nurse){
        int key = nurse.getNurseID();
        if(nurseDb.containsKey(key)) return "already Exists";
        nurseDb.put(key, nurse);
        return "added Successfully";
    }

    public List<Nurse> all(){
        return nurseDb.values().stream().toList();
    }

}
