package com.application.HPDM.Patient;

import java.time.LocalDate;
import java.util.List;

import com.application.HPDM.Relationship_Appointment.Appointment;
import com.application.HPDM.Relationship_Occupy.Occupy;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="patient")
public class Patient {
//    patientId SERIAL NOT NULL,
//    patientName VARCHAR(100) NOT NULL,
//    patientDob DATE NOT NULL,
//    patientGender VARCHAR(10) NOT NULL,
//    patientMedicalRecord VARCHAR(400) NOT NULL,
//    patientPhone VARCHAR(15) NOT NULL,
//
//    patientEmail VARCHAR(100) NOT NULL,
//    patientPassword VARCHAR(100) NOT NULL,
//    PRIMARY KEY (patientId)
    @Id
    @GeneratedValue()
    private Long patientId;

    @Length(max = 25, min=1)
    @NotBlank(message = "Please enter patient's first name")
    private String patientFirstName;
    @Length(max = 25, min=1)
    @NotBlank(message = "Please enter patient's last name")
    private String patientLastName;
    private LocalDate patientDob;
    @Length(max = 20, min=4)
    private String patientGender;
    @Length(max = 200,min=1)
    private String patientMedicalRecord;
    @NotBlank(message = "Please enter patient phone number")
    @Column(unique=true)
    @Length(max = 15)
    private String patientPhone;
    @NotBlank(message = "Please enter patient email")
    @Column(unique=true)
    @Length(max = 50)
    private String patientEmail;
    @NotBlank(message = "Please enter patient password at least 8 characters")
    @Length(max = 50, min = 8)
    private String patientPassword;

    @OneToMany(mappedBy = "patientID")
    private List<Appointment> appointmentList;

    @OneToMany(mappedBy = "patientID")
    private List<Occupy> occupiesList;
    public Patient(String patientFirstName, String patientLastName, LocalDate patientDob, String patientGender, String patientMedicalRecord, String patientPhone, String patientEmail, String patientPassword) {

        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientDob = patientDob;
        this.patientGender = patientGender;
        this.patientMedicalRecord = patientMedicalRecord;
        this.patientPhone = patientPhone;
        this.patientEmail = patientEmail;
        this.patientPassword = patientPassword;
    }
    public Patient() {
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public LocalDate getPatientDob() {
        return patientDob;
    }

    public void setPatientDob(LocalDate patientDob) {
        this.patientDob = patientDob;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientMedicalRecord() {
        return patientMedicalRecord;
    }

    public void setPatientMedicalRecord(String patientMedicalRecord) {
        this.patientMedicalRecord = patientMedicalRecord;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientPassword() {
        return patientPassword;
    }

    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword;
    }
}
