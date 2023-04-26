package com.application.HPDM.Relationship_Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment saveAppointment(Appointment appointment);
    List<Appointment> fetchAppointmentList();
    List<Appointment> fetchAppointmentByPatientID(Long patientId);
    List<Appointment> fetchAppointmentByDoctorID(Long doctorId);
}
