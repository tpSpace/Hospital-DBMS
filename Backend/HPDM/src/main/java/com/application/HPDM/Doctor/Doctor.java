package com.application.HPDM.Doctor;

import com.application.HPDM.Department.Department;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

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

    @NotBlank(message = "Please enter doctor name")
    @Length(max = 100, min = 1)
    private String doctorName;

    @NotBlank(message = "Please enter doctor's phone number")
    @Length(max = 15, min = 1)
    private String doctorPhoneNum;
    private LocalDate doctorDob;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "DoctorDepartmentID", referencedColumnName = "departmentID")
    private Department departmentID;

    @NotBlank(message = "Please enter doctor email")
    @Length(max = 50, min = 8)
    private String doctorEmail;

    @NotBlank(message = "Please enter doctor password")
    @Length(max = 50, min = 1)
    private String doctorPassword;

    public Doctor(){}

    public Doctor(String name, String phoneNum, LocalDate dob,Department departmentID, String doctorEmail, String doctorPassword){
        this.doctorName = name;
        this.doctorPhoneNum = phoneNum;
        this.doctorDob = dob;
        this.setDepartmentId(departmentID);
        this.doctorEmail = doctorEmail;
        this.doctorPassword = doctorPassword;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return this.doctorName;
    }

    public void setName(String name) {
        this.doctorName = name;
    }

    public String getPhoneNum() {
        return this.doctorPhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.doctorPhoneNum = phoneNum;
    }

    public LocalDate getDob() {
        return this.doctorDob;
    }

    public void setDob(LocalDate dob) {
        this.doctorDob = dob;
    }

    public Department getDepartmentId() {
        return departmentID;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentID = departmentId;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }
}