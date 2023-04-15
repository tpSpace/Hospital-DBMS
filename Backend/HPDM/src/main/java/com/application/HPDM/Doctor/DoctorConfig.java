package com.application.HPDM.Doctor;

import com.application.HPDM.Department.Department;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.Month;

import java.util.List;

@Configuration
public class DoctorConfig {
    @Bean
    CommandLineRunner doctorCommandLineRunner(DoctorRepository doctorRepository){
        return args -> {
            Department ngu = new Department("ngu");
            Department vl = new Department("vl");
            Doctor Alex = new Doctor("Alex","0903696969",
                    LocalDate.of(1996, Month.JANUARY, 2), ngu );
            Doctor amongus = new Doctor("sus","42096969",
                    LocalDate.of(26, Month.JANUARY, 1), ngu );
            Doctor vaidan = new Doctor("vd","445969",
                    LocalDate.of(2604, Month.JANUARY, 1), vl );
            doctorRepository.saveAll(List.of(Alex,amongus,vaidan));
        };
    }
}
