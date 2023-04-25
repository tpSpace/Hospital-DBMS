package com.application.HPDM.Relationship_Appointment;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private AppointmentRepository appointmentRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(Appointment.class);
    @PostMapping("/appointment")
    public Appointment saveAppointment(@Valid @RequestBody Appointment appointment) {
        LOGGER.info("Inside saveAppointment of AppointmentController");
        return appointmentService.saveAppointment(appointment);
    }
    @GetMapping("/appointment")
    public List<Appointment> fetchAppointmentList() {return appointmentRepository.findAll();}

    @GetMapping("/appointment/doctor/{doctorId}")
    public Appointment fetchAppointmentByDoctorID(@PathVariable("doctorId") Long doctorId) {
        return appointmentService.fetchAppointmentByDoctorID(doctorId);
    }

    @GetMapping("/appointment/patient/{patientId}")
    public Appointment fetchAppointmentByPatientID(@PathVariable("patientId") Long patientId) {
        return appointmentService.fetchAppointmentByPatientID(patientId);
    }
}
