package com.application.HPDM.TakeCare;

import com.application.HPDM.Nurse.Nurse;
import com.application.HPDM.Nurse.NurseController;
import com.application.HPDM.Patient.Patient;
import com.application.HPDM.Patient.PatientController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Configuration
public class TakeCareConfig {
    @Bean
    CommandLineRunner takecareCommandLineRunner(TakeCareRespository takeCareRespository,
                                                   NurseController nurseController,
                                                   PatientController patientController){
        return args -> {

            Nurse nurse1 = nurseController.fetchNurseByID(1L);
            Patient patient1 = patientController.getPatientById(2L);

            TakeCare takeCare1 = new TakeCare(patient1,nurse1,
                    LocalDate.of(2020, Month.OCTOBER, 1));

            takeCareRespository.saveAll(List.of(takeCare1));
        };
    }
}
