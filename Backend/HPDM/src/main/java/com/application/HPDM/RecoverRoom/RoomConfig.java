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
            Room room1 = new Room("Recovery Room 1");
            Room room2 = new Room("Recovery Room 2");
            Room room3 = new Room("Recovery Room 3");
            Room room4 = new Room("Recovery Room 4");
            Room room5 = new Room("Recovery Room 5");
            Room room6 = new Room("Recovery Room 6");
            Room room7 = new Room("Recovery Room 7");
            Room room8 = new Room("Recovery Room 8");
            Room room9 = new Room("Recovery Room 9");
            Room room10 = new Room("Recovery Room 10");
            Room room11 = new Room("Operation Room 1");
            Room room12 = new Room("Operation Room 2");
            Room room13 = new Room("Operation Room 3");
            Room room14 = new Room("Operation Room 4");
            Room room15 = new Room("Operation Room 5");
            Room room16 = new Room("Surgery Room 1");
            Room room17 = new Room("Surgery Room 2");
            Room room18 = new Room("Surgery Room 3");
            Room room19 = new Room("Surgery Room 4");
            Room room20 = new Room("Surgery Room 5");
            Room room21 = new Room("Recovery Room 11");
            Room room22 = new Room("Recovery Room 12");
            Room room23 = new Room("Recovery Room 13");
            Room room24 = new Room("Recovery Room 14");
            Room room25 = new Room("Recovery Room 15");
            Room room26 = new Room("Recovery Room 16");
            Room room27 = new Room("Recovery Room 17");
            Room room28 = new Room("Recovery Room 18");
            Room room29 = new Room("Recovery Room 19");
            Room room30 = new Room("Recovery Room 20");
            Room room31 = new Room("Recovery Room 21");
            Room room32 = new Room("Recovery Room 22");
            Room room33 = new Room("Recovery Room 23");
            Room room34 = new Room("Recovery Room 24");
            Room room35 = new Room("Recovery Room 25");
            Room room36 = new Room("Emergency Room 1");
            Room room37 = new Room("Emergency Room 2");
            Room room38 = new Room("Emergency Room 3");
            Room room39 = new Room("Emergency Room 4");
            Room room40 = new Room("Emergency Room 5");
            Room room41 = new Room("Emergency Room 6");
            Room room42 = new Room("Emergency Room 7");
            Room room43 = new Room("Emergency Room 8");
            Room room44 = new Room("Emergency Room 9");
            Room room45 = new Room("Emergency Room 10");
            Room room46 = new Room("Priority Room 1");
            Room room47 = new Room( "Priority Room 2");
            Room room48 = new Room("Priority Room 3");
            Room room49 = new Room("Priority Room 4");
            Room room50 = new Room("Priority Room 5");

            roomRepository.saveAll(List.of(room1, room2,room3,room4,room5,room6,room7,room8,room9,
                    room10, room11, room12,room13,room14,room15,room16,room17,room18,room19,room20,
                    room21,room22,room23,room24,room25,room26,room27,room28,room29,room30,
                    room31,room32,room33,room33,room34,room35,room36,room37,room38,room39,room40,
                    room41,room42,room43,room44,room45,room46,room47,room48,room49,room50));
        };
    }
}

