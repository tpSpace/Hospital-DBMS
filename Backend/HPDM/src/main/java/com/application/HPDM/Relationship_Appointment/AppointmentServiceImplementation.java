package com.application.HPDM.Relationship_Appointment;

import com.application.HPDM.Doctor.Doctor;
import com.application.HPDM.Doctor.DoctorRepository;
import com.application.HPDM.Patient.Patient;
import com.application.HPDM.Patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
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
        if(appointment.getDoctor() == null){
            appointment.setDoctor(findFreeDoctor(appointment.getDate()));
        }
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
    @Override
    public Doctor findFreeDoctor(LocalDate date){
        for(Doctor d : doctorRepository.findAll()) {
            List<LocalDate> doctorDate = new ArrayList<>();

            for (Appointment a : fetchAppointmentByDoctorID(d.getDoctorId())) {
                doctorDate.add(a.getDate());
            }
            if (doctorDate.contains(date)){
                continue;
            }
            else return d;
        }
        throw new IllegalStateException("No doctor is free on this day");
    }

}
