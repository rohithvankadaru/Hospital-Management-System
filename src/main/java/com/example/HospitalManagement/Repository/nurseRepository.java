package com.example.HospitalManagement.Repository;

import com.example.HospitalManagement.Models.Nurse;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class nurseRepository {
    HashMap<Integer, Nurse> nurseDb = new HashMap<>();

    public String add(Nurse nurse){
        int key = nurse.getNurseID();
       // if(nurseDb.containsKey(key)) return "already Exists";
        nurseDb.put(key, nurse);
        return "added Successfully";
    }

    public String update(int id, int age){
        if(nurseDb.containsKey(id)){
            Nurse currNurse = nurseDb.get(id);
            currNurse.setAge(age);
            nurseDb.put(id, currNurse);
            return "successfully updated";
        }
        return "no such nurse";
    }

    public List<Nurse> getAll(){
        return nurseDb.values().stream().toList();
    }

}
