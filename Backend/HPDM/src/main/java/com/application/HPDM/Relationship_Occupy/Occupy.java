package com.application.HPDM.Relationship_Occupy;

import com.application.HPDM.Patient.Patient;
import com.application.HPDM.RecoverRoom.Room;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Occupy {
    @Id
    @GeneratedValue
    private Long occupyID;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "patientID", referencedColumnName = "patientId", nullable = false)
    private Patient patientID;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "roomID", referencedColumnName = "roomId", nullable = false)
    private Room roomID;

    @Column(
            name = "Date Enter",
            nullable = false
    )
    private LocalDate DateEnter;

    @Column(
            name = "Date Leave",
            nullable = true
    )
    private LocalDate DateLeave;

    public Occupy(Patient patientID, Room roomID, LocalDate dateEnter, LocalDate dateLeave) {
        this.setPatientID(patientID);
        this.setRoomID(roomID);
        DateEnter = dateEnter;
        DateLeave = dateLeave;
    }

    public Occupy(){}
    public void setPatientID(Patient patientID) {
        this.patientID = patientID;
    }

    public void setRoomID(Room roomID) {
        this.roomID = roomID;
    }

    public void setDateEnter(LocalDate dateEnter) {
        DateEnter = dateEnter;
    }

    public void setDateLeave(LocalDate dateLeave) {
        DateLeave = dateLeave;
    }

    public Long getOccupyID(){
        return this.occupyID;
    }
    public Long getPatientID() {
        return patientID.getPatientId();
    }

    public Long getRoomID() {
        return roomID.getRoomId();
    }

    public LocalDate getDateEnter() {
        return DateEnter;
    }

    public LocalDate getDateLeave() {
        return DateLeave;
    }
}
