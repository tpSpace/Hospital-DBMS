package com.application.HPDM.RecoverRoom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RoomConfig {
    @Bean
    CommandLineRunner roomCommandLineRunner(RoomRepository roomRepository) {
        return args -> {
            Room room1 = new Room("roomName1");
            Room room2 = new Room("roomName2");
            
            roomRepository.saveAll(List.of(room1, room2));
        };
    }
}

