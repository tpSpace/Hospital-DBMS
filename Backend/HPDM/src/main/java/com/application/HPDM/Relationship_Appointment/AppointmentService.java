package com.application.HPDM.Relationship_Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment saveAppointment(Appointment appointment);
    List<Appointment> fetchAppointmentList();
    Appointment fetchAppointmentByPatientID(Long patientId);
    Appointment fetchAppointmentByDoctorID(Long doctorId);
}
