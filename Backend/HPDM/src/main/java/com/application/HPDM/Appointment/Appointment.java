package com.application.HPDM.Appointment;

import com.application.HPDM.Department.Department;
import com.application.HPDM.Doctor.Doctor;
import com.application.HPDM.Patient.Patient;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Appointment {

    @EmbeddedId
    private AppointmentKey appointmentID;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId("doctorID")
    @JoinColumn(name = "doctorID",referencedColumnName = "doctorID")
    private Doctor doctorID;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId("patientID")
    @JoinColumn(name = "patientID",referencedColumnName = "patientID")
    private Patient patientID;
    private LocalDate Date;

    public Appointment(Patient patient, Doctor doctor, LocalDate date) {
        this.setPatientID(patient);
        this.setDoctorID(doctor);
        Date = date;
    }

    public void setPatientID(Patient patient) {
        this.patientID =  patient;
    }

    public void setDoctorID(Doctor doctor) {
        this.doctorID = doctor;
    }

}
