package com.application.HPDM.Relationship_InCharge;

import com.application.HPDM.Nurse.Nurse;
import com.application.HPDM.Nurse.NurseController;
import com.application.HPDM.RecoverRoom.Room;
import com.application.HPDM.RecoverRoom.RoomController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class InchargeConfig {
    @Bean
    CommandLineRunner inchargeCommandLineRunner(InchargeRepository inchargeRepository,
                                                NurseController nurseController,
                                                RoomController roomController){
        return args -> {
            Incharge incharge1 = new Incharge(nurseController.fetchNurseByID(1L),
                    roomController.fetchRoomById(1L),
                    LocalDate.of(2020, Month.JANUARY,2), "Day");
            Incharge incharge2 = new Incharge(nurseController.fetchNurseByID(1L),
                    roomController.fetchRoomById(2L),
                    LocalDate.of(2020, Month.JANUARY,2), "Night");
            Incharge incharge3 = new Incharge(nurseController.fetchNurseByID(2L),
                    roomController.fetchRoomById(1L),
                    LocalDate.of(2020, Month.JANUARY,2), "Night");
            Incharge incharge4 = new Incharge(nurseController.fetchNurseByID(5L),
                    roomController.fetchRoomById(10L),
                    LocalDate.of(2020, Month.JANUARY,3), "Night");
            Incharge incharge5 = new Incharge(nurseController.fetchNurseByID(6L),
                    roomController.fetchRoomById(2L),
                    LocalDate.of(2020, Month.JANUARY,4), "Day");
            Incharge incharge6 = new Incharge(nurseController.fetchNurseByID(8L),
                    roomController.fetchRoomById(4L),
                    LocalDate.of(2020, Month.JANUARY,5), "Night");
            Incharge incharge7 = new Incharge(nurseController.fetchNurseByID(10L),
                    roomController.fetchRoomById(9L),
                    LocalDate.of(2020, Month.JANUARY,5), "Night");
            Incharge incharge8 = new Incharge(nurseController.fetchNurseByID(15L),
                    roomController.fetchRoomById(25L),
                    LocalDate.of(2020, Month.JANUARY,5), "Night");
            Incharge incharge9 = new Incharge(nurseController.fetchNurseByID(10L),
                    roomController.fetchRoomById(10L),
                    LocalDate.of(2020, Month.JANUARY,6), "Day");
            Incharge incharge10 = new Incharge(nurseController.fetchNurseByID(2L),
                    roomController.fetchRoomById(2L),
                    LocalDate.of(2020, Month.JANUARY,6), "Day");
            Incharge incharg11 = new Incharge(nurseController.fetchNurseByID(18L),
                    roomController.fetchRoomById(9L),
                    LocalDate.of(2020, Month.JANUARY,6), "Day");
            Incharge incharge12 = new Incharge(nurseController.fetchNurseByID(7L),
                    roomController.fetchRoomById(5L),
                    LocalDate.of(2020, Month.JANUARY,6), "Night");
            Incharge incharge13 = new Incharge(nurseController.fetchNurseByID(10L),
                    roomController.fetchRoomById(7L),
                    LocalDate.of(2020, Month.JANUARY,6), "Night");
            Incharge incharge14 = new Incharge(nurseController.fetchNurseByID(8L),
                    roomController.fetchRoomById(8L),
                    LocalDate.of(2020, Month.JANUARY,7), "Day");
            Incharge incharge15 = new Incharge(nurseController.fetchNurseByID(7L),
                    roomController.fetchRoomById(10L),
                    LocalDate.of(2020, Month.JANUARY,7), "Day");
            Incharge incharge16 = new Incharge(nurseController.fetchNurseByID(17L),
                    roomController.fetchRoomById(27L),
                    LocalDate.of(2020, Month.JANUARY,7), "Night");
            Incharge incharge17 = new Incharge(nurseController.fetchNurseByID(13L),
                    roomController.fetchRoomById(26L),
                    LocalDate.of(2020, Month.JANUARY,7), "Night");
            Incharge incharge18 = new Incharge(nurseController.fetchNurseByID(12L),
                    roomController.fetchRoomById(44L),
                    LocalDate.of(2020, Month.JANUARY,8), "Day");
            Incharge incharge19 = new Incharge(nurseController.fetchNurseByID(20L),
                    roomController.fetchRoomById(29L),
                    LocalDate.of(2020, Month.JANUARY,8), "Day");
            Incharge incharge20 = new Incharge(nurseController.fetchNurseByID(1L),
                    roomController.fetchRoomById(2L),
                    LocalDate.of(2020, Month.JANUARY,8), "Night");
            inchargeRepository.saveAll(List.of(incharge1,incharge2,incharge3,incharge4,
                        incharge4,incharge5,incharge6,incharge7,incharge8,incharge9,incharge10,
                        incharg11,incharge12,incharge13,incharge14,incharge15,incharge16,incharge17,
                        incharge18,incharge19,incharge20));
        };
    }

}
