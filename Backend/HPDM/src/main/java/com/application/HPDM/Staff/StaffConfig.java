package com.application.HPDM.Staff;

import com.application.HPDM.Department.Department;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StaffConfig {
    @Bean
    CommandLineRunner staffCommandLineRunner(StaffRepository staffRepository) {
        return  args -> {
            Department ngu = new Department("ngu");

            Staff staff1 = new Staff("staffName1", LocalDate.of(1995, Month.JANUARY, 1),
                    ngu, "111111111", "staffEmail1", "staffPassword1");
            staffRepository.saveAll(List.of(staff1));
        };
    }
}
