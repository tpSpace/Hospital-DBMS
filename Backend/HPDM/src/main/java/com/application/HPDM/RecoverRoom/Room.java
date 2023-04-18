package com.application.HPDM.RecoverRoom;

import com.application.HPDM.Relationship_InCharge.Incharge;
import com.application.HPDM.Relationship_Occupy.Occupy;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@Table (name = "Room")
public class Room {
//    roomId SERIAL NOT NULL,
//    roomName VARCHAR(50) NOT NULL,
//    PatientId int REFERENCES Patient(patientId),
//
//    PRIMARY KEY (roomId)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    @NotBlank(message = "Please enter room name")
    @Length(max = 50, min = 1)
    private String roomName;

    @OneToMany(mappedBy = "roomID")
    private List<Occupy> occupiesList;

    @OneToMany(mappedBy = "roomID")
    private  List<Incharge> shiftList;
    public Room(String roomName) {
        this.roomName = roomName;
    }
    public Room(){}

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
