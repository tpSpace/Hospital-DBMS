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
            Nurse nurse1 = nurseController.fetchNurseByID(1L);

            Room room1 = roomController.fetchRoomById(1L);
            Room room2 = roomController.fetchRoomById(2L);

            Incharge incharge1 = new Incharge(nurse1, room1,
                    LocalDate.of(2020, Month.JANUARY,2), "Day");
            Incharge incharge2 = new Incharge(nurse1, room2,
                    LocalDate.of(2020, Month.JANUARY,2), "Night");

            inchargeRepository.saveAll(List.of(incharge1,incharge2));
        };
    }

}
