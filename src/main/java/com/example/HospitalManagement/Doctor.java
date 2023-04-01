package com.example.HospitalManagement;

public class Doctor {
   private String name;

   private String specilization;

   private int age;

    private String degree;

    private int doctorID;

    public Doctor(String name, String specilization, int age, String degree, int doctorID) {
        this.name = name;
        this.specilization = specilization;
        this.age = age;
        this.degree = degree;
        this.doctorID = doctorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecilization() {
        return specilization;
    }

    public void setSpecilization(String specilization) {
        specilization = specilization;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }
}
