package com.application.HPDM.Department;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DepartmentConfig {
    @Bean
    CommandLineRunner departmentCommandLineRunner(DepartmentRepository departmentRepository){
        return args -> {
            Department ngu = new Department("ngu");
            Department vl = new Department("vl");
            Department vaidan = new Department("vaidan");

            departmentRepository.saveAll(List.of(ngu, vl,vaidan));
        };
    }
}
