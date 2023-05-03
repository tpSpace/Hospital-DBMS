package com.application.HPDM.Relationship_Appointment;

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
    public Appointment saveAppointment(@RequestBody Appointment appointment){
        //LOGGER.info("Inside saveAppointment of AppointmentController");
        return appointmentService.saveAppointment(appointment);
    }
    @PostMapping("/appointment/{patientID}")
    public Appointment saveAppointmentByPatientID(@PathVariable("patientID") Long patientID,
                                                  @RequestBody Appointment appointment){
        return appointmentService.saveAppointmentByPatientID(appointment,patientID);
    }
    @GetMapping("/appointment")
    public List<Appointment> fetchAppointmentList() {return appointmentRepository.findAll();}

    @GetMapping("/appointment/doctor/{doctorId}")
    public List<Appointment> fetchAppointmentByDoctorID(@PathVariable("doctorId") Long doctorId) {
        return appointmentService.fetchAppointmentByDoctorID(doctorId);
    }

    @GetMapping("/appointment/patient/{patientId}")
    public List<Appointment> fetchAppointmentByPatientID(@PathVariable("patientId") Long patientId) {
        return appointmentService.fetchAppointmentByPatientID(patientId);
    }
}
