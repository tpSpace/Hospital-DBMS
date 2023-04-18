package com.application.HPDM.RecoverRoom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;


@RestController
@CrossOrigin("*")
public class RoomController {
    @Autowired
    private RoomService roomService;
    private final Logger LOGGER = LoggerFactory.getLogger(Room.class);
    @PostMapping("/room")
    public Room saveRoom(@Valid @RequestBody Room room) {
        LOGGER.info("Inside saveRoom of RoomController");
        return roomService.saveRoom(room);
    }
    @GetMapping("/room")
    public List<Room> fetchRoomList() {return roomService.fetchRoomList();}
    @GetMapping("/room/{id}")
    public Room fetchRoomById(@PathVariable("id") Long roomId) {
        return roomService.fetchRoomByID(roomId);
    }
    @GetMapping("/room/name/{name}")
    public Room fetchRoomByName(@PathVariable("name") String roomName) {
        return roomService.fetchRoomByName(roomName);
    }
    @DeleteMapping("/room/{id}")
    public String deleteRoomByID(@PathVariable("id") Long roomId) {
        roomService.deleteRoomByID(roomId);
        return "Room has been deleted";
    }

    @PutMapping("/room/{id}")
    public Room updateRoom(@PathVariable("id") Long roomId,
                           @RequestBody Room room) {
        return roomService.updateRoom(roomId,room);
    }

}
