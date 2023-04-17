package com.application.HPDM.Room;

import com.application.HPDM.Patient.Patient;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
//    roomId SERIAL NOT NULL,
//    roomName VARCHAR(50) NOT NULL,
//    PatientId int REFERENCES Patient(patientId),
//
//    PRIMARY KEY (roomId)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    @NotBlank(message = "Please enter nurse name")
    @Length(max = 50, min = 1)
    private String roomName;

//    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
//    @JoinColumn(name = "patientId", referencedColumnName = "patientId")
//    private Patient patientId;

    public Room(String roomName) {
        this.roomName = roomName;
//        this.setPatientId(patientId);
    }
}
