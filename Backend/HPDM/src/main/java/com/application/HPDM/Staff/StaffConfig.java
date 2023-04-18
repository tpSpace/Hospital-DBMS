package com.application.HPDM.Staff;

import com.application.HPDM.Department.Department;
import com.application.HPDM.Department.DepartmentController;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StaffConfig {
    @Bean
    CommandLineRunner staffCommandLineRunner(StaffRepository staffRepository, DepartmentController departmentController) {
        return  args -> {
            Department department1 = departmentController.getDepartmentById(1L);
            Department department2 = departmentController.getDepartmentById(2L);
            Staff staff1 = new Staff("Hung", LocalDate.of(2003, Month.DECEMBER,23),department1,"0902934234","whatname@nick.com","nopassword");
            Staff staff2 = new Staff("Khoi", LocalDate.of(2003, Month.DECEMBER,23),department2,"43354523424","nolife@sick.com","nopassword");
            staffRepository.saveAll(List.of(staff1, staff2));

        };
    }
}
