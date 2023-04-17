package com.application.HPDM.Nurse;

import com.application.HPDM.Department.Department;
import com.application.HPDM.Department.DepartmentConfig;
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
            Department vaidan = departmentController.getDepartmentById(3L);

            Nurse Kkmanmnan = new Nurse("KKmanman","42069",
                    LocalDate.of(1296, Month.FEBRUARY, 2), vaidan);
            nurseRepository.saveAll(List.of(Kkmanmnan));
        };
    }
}
