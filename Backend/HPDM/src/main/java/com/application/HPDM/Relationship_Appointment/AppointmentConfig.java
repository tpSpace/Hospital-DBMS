package com.application.HPDM.Relationship_Appointment;

import com.application.HPDM.Doctor.Doctor;
import com.application.HPDM.Doctor.DoctorController;
import com.application.HPDM.Patient.Patient;
import com.application.HPDM.Patient.PatientController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AppointmentConfig {
    @Bean
    CommandLineRunner appointmentCommandLineRunner(AppointmentRepository appointmentRepository,
                                                   DoctorController doctorController,
                                                   PatientController patientController){
        return args -> {
            Doctor doctor1 = doctorController.getDoctorById(1L);
            Patient patient1 = patientController.getPatientById(2L);

            Appointment appointment1 = new Appointment(patient1,doctor1,
                    LocalDate.of(2020, Month.OCTOBER, 1));

            appointmentRepository.saveAll(List.of(appointment1));
        };
    }
}
