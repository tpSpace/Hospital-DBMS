package com.application.HPDM.Patient;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
    private String patientName;
    private String patientDob;
    private String patientGender;
    private String patientMedicalRecord;
    private String patientPhone;
    private String patientEmail;
    private String patientPassword;


    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientDob() {
        return patientDob;
    }

    public void setPatientDob(String patientDob) {
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
