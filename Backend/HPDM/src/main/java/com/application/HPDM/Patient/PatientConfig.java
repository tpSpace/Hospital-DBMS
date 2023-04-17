package com.application.HPDM.Patient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Configuration
public class PatientConfig {
    @Bean
    CommandLineRunner patientCommandLineRunner(PatientRepository patientRepository){
        return args -> {
            Patient patient1 = new Patient("Khoi","Nguyen",LocalDate.of(1996, Month.JANUARY, 2),"Male","N/A","0903","something@who.com","schaupielerin");
            Patient patient2 = new Patient("Tinle","Alex",LocalDate.of(2003,Month.APRIL,1),"Female","N/A","094353","hey@question.com","helwefweflo");
            patientRepository.saveAll(List.of(patient1, patient2));
        };
    }
}
