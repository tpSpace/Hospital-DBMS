package com.application.HPDM.Relationship_Appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@Service
public class AppointmentServiceImplementation implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> fetchAppointmentList() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment fetchAppointmentByPatientID(Long patientId) {
        Optional<Appointment> appointment =
                appointmentRepository.findById(patientId);
        return appointment.get();
    }

    @Override
    public Appointment fetchAppointmentByDoctorID(Long doctorId) {
        Optional<Appointment> appointment =
                appointmentRepository.findById(doctorId);
        return appointment.get();
    }
}
