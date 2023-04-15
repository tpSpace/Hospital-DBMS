package com.application.HPDM.Department;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DepartmentConfig {
    @Bean
    CommandLineRunner commandLineRunner(DepartmentRepository Repository){
        return args -> {
            Department Health = new Department("Health");
            Department chet = new Department("chet");
            Department ga = new Department("ga");
            Repository.saveAll(List.of(Health,chet,ga));
        };
    }

}
