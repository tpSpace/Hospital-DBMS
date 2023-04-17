package com.application.HPDM.Room;

import com.application.HPDM.Patient.Patient;
import com.application.HPDM.Patient.PatientController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class RoomConfig {
    @Bean
    CommandLineRunner roomCommandLineRunner(RoomRepository roomRepository, PatientController patientController) {
        return args -> {
//            Patient patient1 = patientController.getPatientById(1L);
//            Patient patient2 = patientController.getPatientById(2L);
            Room room1 = new Room("roomName1");
            Room room2 = new Room("roomName2");
            
            roomRepository.saveAll(List.of(room1, room2));
        };
    }
}

