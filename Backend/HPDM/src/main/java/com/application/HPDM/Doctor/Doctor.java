package com.application.HPDM.Doctor;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Doctor {
    @Id
    @SequenceGenerator(
            name = "doctor_sequence",
            sequenceName = "doctor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "doctor_sequence"
    )
    private Long Id;
    private String name;
    private String phoneNum;
    private LocalDate dob;
    private Long departmentId;

    public Doctor(){}

    public Doctor(String name, String phoneNum, LocalDate dob, Long departmentId){
        this.name = name;
        this.phoneNum = phoneNum;
        this.dob = dob;
        this.departmentId = departmentId;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}