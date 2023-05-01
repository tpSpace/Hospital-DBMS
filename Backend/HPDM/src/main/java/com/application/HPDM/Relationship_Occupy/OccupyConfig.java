package com.application.HPDM.Relationship_Occupy;

import com.application.HPDM.Patient.Patient;
import com.application.HPDM.Patient.PatientController;
import com.application.HPDM.RecoverRoom.Room;
import com.application.HPDM.RecoverRoom.RoomController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class OccupyConfig {
    @Bean
    CommandLineRunner occupyCommandLineRunner(OccupyRepository occupyRepository,
                                              PatientController patientController,
                                              RoomController roomController){
        return args -> {
            Patient patient1 = patientController.getPatientById(2L);
            Patient patient2 = patientController.getPatientById(1L);
            Room room1 = roomController.fetchRoomById(1L);

            Occupy occupy1 = new Occupy(patient1,room1, LocalDate.of(
                    2020, Month.JANUARY,2),null
            );

            Occupy occupy2 = new Occupy(patient2,room1, LocalDate.of(
                    2020, Month.JANUARY,2),
                    LocalDate.of(
                            2020, Month.JANUARY,3)
            );
            occupyRepository.saveAll(List.of(occupy1,occupy2));
        };
    }
}
