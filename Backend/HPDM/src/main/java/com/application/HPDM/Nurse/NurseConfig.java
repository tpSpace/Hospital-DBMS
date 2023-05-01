package com.application.HPDM.Nurse;

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

            Nurse a = new Nurse("Arax Troc","090654579",
                    LocalDate.of(1999,Month.FEBRUARY,16), departmentController.getDepartmentById(1L),
                    "araxtroc@gmail.com","superpassword");
            Nurse b = new Nurse("Becand Freemaw", "094277691",
                    LocalDate.of(1980, Month.SEPTEMBER,02), departmentController.getDepartmentById(2L),
                    "bemaw@gmail.com", "lmaonerdy");
            Nurse c = new Nurse("Crowler Naown", "09427321",
                    LocalDate.of(1920, Month.DECEMBER,5), departmentController.getDepartmentById(2L),
                    "crownan@gmail.com", "dfjeija000");
            Nurse d = new Nurse("Dripix Nipix", "096821691",
                    LocalDate.of(1972, Month.MARCH,3), departmentController.getDepartmentById(3L),
                    "dripix@gmail.com", "vlluondoba");
            Nurse e = new Nurse("Emani Loide", "096309691",
                    LocalDate.of(1982, Month.OCTOBER,17), departmentController.getDepartmentById(3L),
                    "emande@gmail.com", "bdzbatroioi");
            Nurse f = new Nurse("Freddy Teddy", "094322221",
                    LocalDate.of(1991,  Month.FEBRUARY,9), departmentController.getDepartmentById(3L),
                    "freteddy@gmail.com", "huhuhuhuhhu");
            Nurse g = new Nurse("Gnawr Gardaw", "082917322",
                    LocalDate.of(1900, Month.APRIL,4), departmentController.getDepartmentById(4L),
                    "gnawd@gmail.com", "kawaiicute");
            Nurse h = new Nurse("Howdy Maoui", "0961111111",
                    LocalDate.of(1988, Month.AUGUST,19), departmentController.getDepartmentById(5L),
                    "howdyyaaa@gmail.com", "yippyyyy1");
            Nurse i = new Nurse("Imsporet Ussys", "0969696969",
                    LocalDate.of(1977, Month.JULY,27), departmentController.getDepartmentById(5L),
                    "imporset@gmail.com", "sussustuguss");
            Nurse k = new Nurse("Kere Pordet", "092387322",
                    LocalDate.of(1999, Month.NOVEMBER,10), departmentController.getDepartmentById(4L),
                    "kerepord@gmail.com", "09la10000100");
            Nurse l = new Nurse("Lint Maox", "09682323",
                    LocalDate.of(1969, Month.SEPTEMBER,6), departmentController.getDepartmentById(6L),
                    "lmaoxint@gmail.com", "troioikhoqua");
            Nurse j = new Nurse("Juston Huston", "09777222",
                    LocalDate.of(1956, Month.NOVEMBER,11), departmentController.getDepartmentById(7L),
                    "justhustom@gmail.com", "hahaimstudpid");
            Nurse m = new Nurse("Meggan Lova-nian", "0988888888",
                    LocalDate.of(2000, Month.JANUARY,2), departmentController.getDepartmentById(8L),
                    "meglovan@gmail.com", "ehhehhehhhh");
            Nurse n = new Nurse("Nonaw Knac", "097823122",
                    LocalDate.of(1974, Month.MARCH,23), departmentController.getDepartmentById(9L),
                    "nonawknac@gmail.com", "bruhohmahgod");
            Nurse o = new Nurse("Oxrie Thueg", "096822221",
                    LocalDate.of(1972, Month.MARCH,31), departmentController.getDepartmentById(10L),
                    "oxreg@gmail.com", "vlhetcuuhuhu");
            Nurse q = new Nurse("Quincy Jr.", "0962221691",
                    LocalDate.of(1980,Month.OCTOBER ,12), departmentController.getDepartmentById(2L),
                    "quincydincy@gmail.com", "sonofquincy");
            Nurse r = new Nurse("Ragoon Ceron", "092857391",
                    LocalDate.of(1995, Month.MAY,23), departmentController.getDepartmentById(5L),
                    "ragooncon@gmail.com", "ecec9999111");
            Nurse s = new Nurse("Shawn Eggan", "092313727",
                    LocalDate.of(1972, Month.MARCH,3), departmentController.getDepartmentById(6L),
                    "shawne@gmail.com", "whatisgoingon1010");
            Nurse t = new Nurse("Trine Oller", "0944321691",
                    LocalDate.of(1973, Month.JUNE,19), departmentController.getDepartmentById(7L),
                    "trollerine@gmail.com", "hehefunny");
            Nurse u = new Nurse("Unnie Tunnie", "0967756591",
                    LocalDate.of(1987, Month.MARCH,3), departmentController.getDepartmentById(10L),
                    "unntunn@gmail.com", "utututututul");
            nurseRepository.saveAll(List.of(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,q,r,s,t,u));
        };
    }
}
