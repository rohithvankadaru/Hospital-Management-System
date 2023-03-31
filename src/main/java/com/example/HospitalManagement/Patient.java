package com.example.HospitalManagement;

public class Patient {

    private int patientID;

    private String name;

    private String disease;

    private int age;

    public Patient(Integer patientId, String name, String disease, Integer age) {
        this.patientID = patientID;
        this.name = this.name;
        this.disease = this.disease;
        this.age = this.age;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
