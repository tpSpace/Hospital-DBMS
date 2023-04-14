package com.application.HPDM.Patient;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Patient {
//    patientName VARCHAR(100) NOT NULL,
//    patientDob DATE NOT NULL,
//    patientGender VARCHAR(10) NOT NULL,
//    patientMedicalRecord VARCHAR(400) NOT NULL,
//    patientPhone smallint,
    @Id
    @GeneratedValue()
    private Long patientId;
    private String patientName;
    private String patientDob;
    private String patientGender;
    private String patientMedicalRecord;
    private String patientPhone;

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
}
