package com.application.HPDM.Doctor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

import java.util.List;

@Configuration
public class DoctorConfig {
    @Bean
    CommandLineRunner commandLineRunner(DoctorRepository doctorRepository){
        return args -> {
            Doctor Alex = new Doctor("Alex", "0903696969", LocalDate.of(1996, Month.JANUARY, 25), 1L);
            doctorRepository.saveAll(List.of(Alex));
        };
    }
}
