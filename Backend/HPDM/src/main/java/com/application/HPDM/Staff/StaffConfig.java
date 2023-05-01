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
            Staff a = new Staff("Hung Nguyen", LocalDate.of(2003, Month.DECEMBER,23),
                    departmentController.getDepartmentById(1L),
                    "0902934234","whatname@nick.com","nopassword1");
            Staff b = new Staff("Khoi Ng.", LocalDate.of(2003, Month.MARCH,8),
                    departmentController.getDepartmentById(2L),
                    "43354523424","nolife@sick.com","nopassword2");
            Staff c = new Staff("Huy Ngo", LocalDate.of(2003, Month.JUNE,29),
                    departmentController.getDepartmentById(2L),
                    "0946274888","perterhuy@gmail.com","nopassword3");
            Staff d = new Staff("Khang Ho", LocalDate.of(2003, Month.DECEMBER,25),
                    departmentController.getDepartmentById(3L),
                    "43232114","khangdethuong@gmail.com","kkmanman");
            Staff e = new Staff("Khang Fam", LocalDate.of(2003, Month.FEBRUARY,9),
                    departmentController.getDepartmentById(3L),
                    "0946180277","khangbdqua@gmail.com","kkmanman2");
            Staff f = new Staff("Binh Nguyen", LocalDate.of(2003, Month.DECEMBER,19),
                    departmentController.getDepartmentById(4L),
                    "093433314","mrbin@gmail.com","kk231a231n");
            Staff g = new Staff("Ton ND", LocalDate.of(2003, Month.MARCH,31),
                    departmentController.getDepartmentById(5L),
                    "093553873","tonnd@gmail.com","kkmanman3123");
            Staff h = new Staff("Tohsaka Rin", LocalDate.of(1980, Month.FEBRUARY,3),
                    departmentController.getDepartmentById(6L),
                    "091538366","tohsakarin0302@gmail.com","duchuybdvai");
            Staff i = new Staff("Meowwo", LocalDate.of(1999, Month.MAY ,29),
                    departmentController.getDepartmentById(7L),
                    "090932114","meowowowo@gmail.com","imverybadowo");
            Staff j = new Staff("Auby Rey", LocalDate.of(2001, Month.JANUARY,12),
                    departmentController.getDepartmentById(8L),
                    "0843121214","aubryadwwd@gmail.com","vaicadanluon");
            Staff k = new Staff("Mari Omi", LocalDate.of(1998, Month.MARCH,1),
                    departmentController.getDepartmentById(9L),
                    "091232333","iloveyousunny@gmail.com","something!");
            Staff l = new Staff("Basil Leaft", LocalDate.of(2000, Month.FEBRUARY,18),
                    departmentController.getDepartmentById(10L),
                    "091326667","flowerboy@gmail.com","sunflowers");
            staffRepository.saveAll(List.of(a, b,c,d,e,f,g,h,i,j,k,l));

        };
    }
}
