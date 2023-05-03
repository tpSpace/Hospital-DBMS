package com.application.HPDM.Doctor;

import com.application.HPDM.Department.DepartmentController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class DoctorConfig {
    @Bean
    CommandLineRunner doctorCommandLineRunner(DoctorRepository doctorRepository,
                                              DepartmentController departmentController){
        return args -> {

            Doctor Alex = new Doctor("Alex","0903696969",
                    LocalDate.of(1996, Month.JANUARY, 2), departmentController.getDepartmentById(1L),
                    "alex@gmail.com", "alex123");
            Doctor Among = new Doctor("Among Us","0937276192",
                    LocalDate.of(1969, Month.JUNE, 9), departmentController.getDepartmentById(2L),
                    "amongus69@gmail.com", "AMONGUS" );
            Doctor Khai = new Doctor("Khai Ng.","4459694223",
                    LocalDate.of(1990, Month.JANUARY, 1), departmentController.getDepartmentById(2L) ,
                    "khaiNg@gmail.com", "123456");
            Doctor Brian = new Doctor("Brian Yip","7749142",
                    LocalDate.of(1985, Month.FEBRUARY, 14), departmentController.getDepartmentById(3L) ,
                    "Bryan@gmail.com", "HiIMBr");
            Doctor Trayarus = new Doctor("Dr.Trayarus","09564201",
                    LocalDate.of(1960, Month.FEBRUARY, 14), departmentController.getDepartmentById(5L) ,
                    "Trayarus@gmail.com", "BurnThem");
            Doctor Yippy = new Doctor("Happy Yippy","555777666",
                    LocalDate.of(2000, Month.MARCH, 30), departmentController.getDepartmentById(4L) ,
                    "HappyHappy@gmail.com", "HappyHappyHappy");
            Doctor KaKa = new Doctor("KaManMan","555555555",
                    LocalDate.of(1955, Month.MAY, 5), departmentController.getDepartmentById(6L) ,
                    "kkmanman@gmail.com", "gk3zck");
            Doctor Sery = new Doctor("Seryph Acker","022325839",
                    LocalDate.of(2001, Month.JULY, 27), departmentController.getDepartmentById(10L) ,
                    "SeryphAcker@gmail.com", "HIHELLLOWHY");
            Doctor MunD = new Doctor("Mund Mundo","000010232",
                    LocalDate.of(1990, Month.MARCH,9), departmentController.getDepartmentById(7L) ,
                    "Mundogoeswhere@gmail.com", "hePleases");
            Doctor Neil = new Doctor("Neil Grapes","870987521",
                    LocalDate.of(1990, Month.APRIL, 30), departmentController.getDepartmentById(8L) ,
                    "ilikegrapes@gmail.com", "Neil.G");
            Doctor Linus = new Doctor("Linus Xeno","77985926",
                    LocalDate.of(1991, Month.DECEMBER, 03), departmentController.getDepartmentById(3L) ,
                    "LinuxTechTip@gmail.com", "HiIMBr");
            Doctor Phuc = new Doctor("Phuc Ng.","242293369",
                    LocalDate.of(1990, Month.MARCH, 8), departmentController.getDepartmentById(4L) ,
                    "phucnguyendu@gmail.com", "23");
            Doctor Chisato = new Doctor("Chisa Chisato","2421271",
                    LocalDate.of(1990, Month.AUGUST, 07), departmentController.getDepartmentById(4L) ,
                    "ChisatoC@gmail.com", "Takima<3");
            Doctor Blue = new Doctor("Blue Rain","4454332169",
                    LocalDate.of(1987, Month.APRIL, 04), departmentController.getDepartmentById(5L) ,
                    "bluer@gmail.com", "09588111");
            Doctor cheese = new Doctor("Cheezy Weeazy","454230011",
                    LocalDate.of(1956, Month.JUNE , 14), departmentController.getDepartmentById(6L) ,
                    "Cheese@gmail.com", "squeeksqueek");
            Doctor Axees = new Doctor("Traxy Che","3241249",
                    LocalDate.of(1990, Month.FEBRUARY, 14), departmentController.getDepartmentById(7L) ,
                    "TaxyC@gmail.com", "I122T");
            Doctor Cuu = new Doctor("Heloc Blindins","293190421",
                    LocalDate.of(1978, Month.SEPTEMBER, 8), departmentController.getDepartmentById(8L) ,
                    "Helloc@gmail.com", "0606060203");
            Doctor Hetcuu = new Doctor("Recale Poker","231423122",
                    LocalDate.of(1911, Month.OCTOBER, 21), departmentController.getDepartmentById(9L) ,
                    "RecaleP@gmail.com", "HelpmeOMG");
            Doctor Plane = new Doctor("Planer Lainer","090909099",
                    LocalDate.of(2001, Month.SEPTEMBER, 11), departmentController.getDepartmentById(10L) ,
                    "Plane@gmail.com", "ilovebuildings");
            Doctor Spidery = new Doctor("Muffet Pupper","1242199999",
                    LocalDate.of(1982, Month.SEPTEMBER, 1), departmentController.getDepartmentById(4L) ,
                    "Muffeter@gmail.com", "donut123");
            doctorRepository.saveAll(List.of(Alex,Among,Brian,Khai,Linus,
                    MunD,Spidery,Hetcuu,Cuu,Plane,cheese,Axees,Phuc,Chisato,
                    Neil,Blue,KaKa,Sery,Yippy,Trayarus));
        };
    }
}
