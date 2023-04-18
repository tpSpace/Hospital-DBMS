package com.application.HPDM.Relationship_Appointment;

import com.application.HPDM.Doctor.Doctor;
import com.application.HPDM.Patient.Patient;
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
    private LocalDate Date;

//    private String doctorName;
//
//    private String patientName;

    public Appointment(Patient patient, Doctor doctor, LocalDate date) {
        this.setDoctor(doctor);
        this.setPatient(patient);
        this.Date = date;
//        this.patientIDL = patient.getPatientId();
//        this.doctorIDL = doctor.getDoctorId();
//        this.doctorName = doctor.getDoctorName();
//        this.patientName = patient.getPatientFirstName() + " " + patient.getPatientLastName();
    }
    public Appointment(){}

    public Long getAppointmentID() {
        return appointmentID;
    }

//    public Doctor getDoctor() {
//        return doctor;
//    }

//    public Patient getPatient() {
//        return patient;
//    }

    public LocalDate getDate() {
        return Date;
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

    public String getDoctorName() {
        return doctor.getDoctorName();
    }

    public String getPatientName() {
        return patient.getPatientFirstName() + " " + patient.getPatientLastName();
    }
}
