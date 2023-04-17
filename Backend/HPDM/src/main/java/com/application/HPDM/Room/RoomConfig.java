package com.application.HPDM.Room;

import com.application.HPDM.Patient.Patient;
import com.application.HPDM.Patient.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class RoomConfig {
    @Bean
    CommandLineRunner roomCommandLineRunner(RoomRepository roomRepository, PatientRepository patientRepository) {
        return args -> {
            Patient patient1 = new Patient("Khoi","Nguyen", LocalDate.of(1996, Month.JANUARY, 2),"Male","N/A","0903","something@who.com","schaupielerin");
            Patient patient2 = new Patient("Tinle","Alex",LocalDate.of(2003,Month.APRIL,1),"Female","N/A","094353","hey@question.com","helwefweflo");
            patientRepository.saveAll(List.of(patient1,patient2));

            Room room1 = new Room("roomName1", patient1);
            Room room2 = new Room("roomName2", patient2);

            roomRepository.saveAll(List.of(room1, room2));
        };
    }
}

