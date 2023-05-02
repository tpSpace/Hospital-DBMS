package com.application.HPDM.Relationship_Appointment;

import com.application.HPDM.Doctor.Doctor;
import com.application.HPDM.Patient.Patient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Appointment {
    @Id
    @GeneratedValue
    private Long appointmentID;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "doctorID",referencedColumnName = "doctorId")
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "patientID",referencedColumnName = "patientId")
    private Patient patient;
    private LocalDate date;

    public Appointment(Patient patient, Doctor doctor, LocalDate date) {
        this.setDoctor(doctor);
        this.setPatient(patient);
        this.date = date;
    }
    public Appointment(){}

    public Appointment(Patient patient,LocalDate date) {
        this.setPatient(patient);
        this.date = date;
    }
    public Long getAppointmentID() {
        return appointmentID;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date){
        this.date = date;
    }
    public void setPatient(Patient patient) {
        this.patient=  patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Long getPatientID() {
        return patient.getPatientId();
    }

    public Long getDoctorID() {
        return doctor.getDoctorId();
    }
    @JsonIgnore
    public Doctor getDoctor(){
        return this.doctor;
    }
    @JsonIgnore
    public Patient getPatient(){
        return this.patient;
    }
    public String getDoctorName() {
        return doctor.getDoctorName();
    }

    public String getPatientName() {
        return patient.getPatientFirstName() + " " + patient.getPatientLastName();
    }
}
