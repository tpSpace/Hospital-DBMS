package com.application.HPDM.Doctor;

import com.application.HPDM.Appointment.Appointment;
import com.application.HPDM.Department.Department;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

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
    private Long doctorID;
    private String name;
    private String phoneNum;
    private LocalDate dob;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "DoctorDepartmentID", referencedColumnName = "departmentID")
    private Department departmentID;

    @OneToMany(mappedBy = "doctorID")
    private List<Appointment> appointments;
    public Doctor(){}

    public Doctor(String name, String phoneNum, LocalDate dob,Department departmentID){
        this.name = name;
        this.phoneNum = phoneNum;
        this.dob = dob;
        this.setDepartmentId(departmentID);
    }

    public Long getId() {
        return this.doctorID;
    }

    public void setId(Long id) {
        this.doctorID = id;
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

    public Department getDepartmentId() {
        return departmentID;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentID = departmentId;
    }
}