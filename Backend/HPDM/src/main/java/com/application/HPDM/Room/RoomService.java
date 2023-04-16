package com.application.HPDM.Room;


import java.util.List;

public interface RoomService {
    Room saveRoom(Room room);
    List<Room> fetchRoomList();
    Room fetchRoomByID(Long roomId);

    void deleteRoomByID(Long roomId);
    Room fetchRoomByName(String roomName);

    Room updateRoom(Long roomId, Room room);
}
