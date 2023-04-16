package com.application.HPDM.Appointment;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class AppointmentKey implements Serializable {
    @Column(name = "patientID")
    private Long patientID;

    @Column(name = "doctorID")
    private Long doctorID;
}
