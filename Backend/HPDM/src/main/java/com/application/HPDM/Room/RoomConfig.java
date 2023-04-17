package com.application.HPDM.Room;

import com.application.HPDM.Patient.Patient;
import com.application.HPDM.Patient.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Configuration
public class RoomConfig {
    @Bean
    CommandLineRunner roomCommandLineRunner(RoomRepository roomRepository, PatientRepository patientRepository) {
        return args -> {
//            Optional<Patient> patient3 = patientRepository.findById(1L);
//            Optional<Patient> patient4 = patientRepository.findById(2L);
//
//            Room room1 = new Room("roomName1", patient3);
//            Room room2 = new Room("roomName2", patient4);
//
//            roomRepository.saveAll(List.of(room1, room2));
        };
    }
}

