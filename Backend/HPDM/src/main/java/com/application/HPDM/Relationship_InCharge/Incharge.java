package com.application.HPDM.Relationship_InCharge;

import com.application.HPDM.Nurse.Nurse;
import com.application.HPDM.RecoverRoom.Room;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table
public class Incharge {
    @Id
    @GeneratedValue
    private Long inchargeID;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "nurseID", referencedColumnName = "nurseId", nullable = false)
    private Nurse nurseID;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "roomID", referencedColumnName = "roomId", nullable = false)
    private Room roomID;

    @Column(
        name = "Day of shift",
                nullable = false
    )
    private LocalDate date;

    private String shift;

    public Incharge(Nurse nurseID, Room roomID, LocalDate date, String shift) {
        this.setNurseID(nurseID);
        this.setRoomID(roomID);
        this.date = date;
        this.shift = shift;
    }

    public Incharge(){}

    public Long getNurseID() {
        return nurseID.getNurseId();
    }

    public void setNurseID(Nurse nurseID) {
        this.nurseID = nurseID;
    }

    public Long getRoomID() {
        return roomID.getRoomId();
    }

    public void setRoomID(Room roomID) {
        this.roomID = roomID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}
