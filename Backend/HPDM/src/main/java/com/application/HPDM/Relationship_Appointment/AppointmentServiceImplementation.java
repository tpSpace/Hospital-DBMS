package com.application.HPDM.Relationship_Appointment;

import com.application.HPDM.Doctor.DoctorRepository;
import com.application.HPDM.Patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@Service
public class AppointmentServiceImplementation implements AppointmentService{

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    
    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return
                appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> fetchAppointmentList() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> fetchAppointmentByPatientID(Long patientId) {
        List<Appointment> appointmentList = new ArrayList<>();

        for(Appointment a : appointmentRepository.findAll()){
             if(a.getPatientID() == patientId){
                 appointmentList.add(a);
             }
        }
        return appointmentList;
    }

    @Override
    public List<Appointment> fetchAppointmentByDoctorID(Long doctorId) {
        List<Appointment> appointmentList = new ArrayList<>();

        for(Appointment a : appointmentRepository.findAll()){
            if(a.getDoctorID() == doctorId){
                appointmentList.add(a);
            }
        }
        return appointmentList;
    }
}
