package com.application.HPDM.RecoverRoom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    public Room findByRoomNameIgnoreCase(String roomName);
}
