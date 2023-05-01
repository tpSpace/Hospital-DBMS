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
            Department Healthcare = new Department("Healthcare");
            Department Cardiology = new Department("Cardiology");
            Department Beauty = new Department("Beauty");
            Department Emergency = new Department("Emergency");
            Department GeneralSurgery = new Department("General Surgery");
            Department Neurology = new Department("Neurology");
            Department Medicine = new Department("Medicine");
            Department Physiotherapy = new Department("Physiotherapy");
            Department Orthopedics = new Department("Orthopedics");
            Department NutritionAndDietetics = new Department("Nutrition and Dietetics");

            departmentRepository.saveAll(List.of(Healthcare,Cardiology,Beauty,
                    Emergency,GeneralSurgery,Neurology,Medicine,Physiotherapy,Orthopedics,
                    NutritionAndDietetics));
        };
    }
}
