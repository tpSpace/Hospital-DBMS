package com.application.HPDM.Doctor;

import com.application.HPDM.Department.Department;
import com.application.HPDM.Relationship_Appointment.Appointment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

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
    private Long doctorId;

    @NotBlank(message = "Please enter doctor name")
    @Length(max = 100, min = 1)
    private String doctorName;

    @NotBlank(message = "Please enter doctor's phone number")
    @Length(max = 15, min = 1)
    private String doctorPhoneNum;
    private LocalDate doctorDob;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "DoctorDepartmentID", referencedColumnName = "departmentID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Department departmentID;

    @NotBlank(message = "Please enter doctor email")
    @Length(max = 50, min = 8)
    private String doctorEmail;

    @NotBlank(message = "Please enter doctor password")
    @Length(max = 50, min = 1)
    private String doctorPassword;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointmentList;

    public Doctor(){}

    public Doctor(String name, String phoneNum, LocalDate dob,Department departmentID, String doctorEmail, String doctorPassword){
        this.doctorName = name;
        this.doctorPhoneNum = phoneNum;
        this.doctorDob = dob;
        this.setDepartmentId(departmentID);
        this.doctorEmail = doctorEmail;
        this.doctorPassword = doctorPassword;
    }

    public Long getDoctorId() {
        return this.doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return this.doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorPhoneNum() {
        return this.doctorPhoneNum;
    }

    public void setDoctorPhoneNum(String doctorPhoneNum) {
        this.doctorPhoneNum = doctorPhoneNum;
    }

    public LocalDate getDoctorDob() {
        return this.doctorDob;
    }

    public void setDoctorDob(LocalDate dob) {
        this.doctorDob = dob;
    }

    public Long getDepartmentId() {
        return departmentID.getDepartmentID();
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