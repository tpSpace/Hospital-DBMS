package com.application.HPDM.Nurse;

import com.application.HPDM.Department.Department;
import com.application.HPDM.Department.DepartmentController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class NurseConfig {
    @Bean
    CommandLineRunner nurseCommandLineRunner(NurseRepository nurseRepository,
                                             DepartmentController departmentController) {
        return args -> {
            Nurse Kkmanmnan = new Nurse("NYNY","090654579",
                    LocalDate.of(2003,Month.APRIL,16), departmentController.getDepartmentById(1L),
                    "nurse@hotmail.com","superpassword");

            nurseRepository.saveAll(List.of(Kkmanmnan));
        };
    }
}
