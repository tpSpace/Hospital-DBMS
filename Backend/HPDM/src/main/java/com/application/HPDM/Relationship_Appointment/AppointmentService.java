package com.application.HPDM.Relationship_Appointment;

import com.application.HPDM.Doctor.Doctor;
import com.application.HPDM.Patient.Patient;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    Appointment saveAppointment(Appointment appointment);

    Appointment saveAppointmentByPatientID(Appointment appointment,Long patientID);
    List<Appointment> fetchAppointmentList();
    List<Appointment> fetchAppointmentByPatientID(Long patientId);
    List<Appointment> fetchAppointmentByDoctorID(Long doctorId);

    Doctor findFreeDoctor(LocalDate Date);
}
