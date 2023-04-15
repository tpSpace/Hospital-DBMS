package com.application.HPDM.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RoomServiceImplementation implements RoomService{
    @Autowired
    private RoomRepository roomRepository;
    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> fetchRoomList() {
        return roomRepository.findAll();
    }

    @Override
    public Room fetchRoomByID(Long roomId) {
        Optional<Room> room =
                roomRepository.findById(roomId);
        return room.get();
    }

    @Override
    public void deleteRoomByID(Long roomId) {
        roomRepository.deleteById(roomId);
    }

    @Override
    public Room fetchRoomByName(String roomName) {
        return roomRepository.findByRoomNameIgnoreCase(roomName);
    }

    @Override
    public Room updateRoom(Long roomId, Room room) {
        Room roomDb = roomRepository.findById(roomId).get();

        if(Objects.nonNull(room.getRoomName()) &&
        !"".equalsIgnoreCase(room.getRoomName())) {
            roomDb.setRoomName(room.getRoomName());
        }
        return roomRepository.save(roomDb);
    }
}
