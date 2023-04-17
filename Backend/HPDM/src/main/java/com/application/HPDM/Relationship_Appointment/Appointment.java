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
    private Doctor doctorID;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "patientID",referencedColumnName = "patientId")
    private Patient patientID;
    private LocalDate Date;

    public Appointment(Patient patient, Doctor doctor, LocalDate date) {
        this.setDoctorID(doctor);
        this.setPatientID(patient);
        this.Date = date;
    }

    public void setPatientID(Patient patient) {
        this.patientID =  patient;
    }

    public void setDoctorID(Doctor doctor) {
        this.doctorID = doctor;
    }

}
