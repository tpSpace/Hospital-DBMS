package com.application.HPDM.Nurse;

import com.application.HPDM.Department.Department;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class NurseConfig {
    @Bean
    CommandLineRunner nurseCommandLineRunner(NurseRepository nurseRepository) {
        return args -> {
            Department vaidan = new Department("Vaidan");
            Nurse Kkmanmnan = new Nurse("KKmanman","42069",
                    LocalDate.of(1296, Month.FEBRUARY, 2), vaidan);
            nurseRepository.saveAll(List.of(Kkmanmnan));
        };
    }
}
