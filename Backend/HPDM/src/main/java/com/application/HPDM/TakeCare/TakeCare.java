package com.application.HPDM.TakeCare;

import com.application.HPDM.Nurse.Nurse;
import com.application.HPDM.Patient.Patient;
import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table
public class TakeCare {
//    Date INT NOT NULL,
//    PatientID INT NOT NULL,
//    NurseID INT NOT NULL,
//    PRIMARY KEY (PatientID, NurseID),
//    FOREIGN KEY (PatientID) REFERENCES Patient(PatientID),
//    FOREIGN KEY (NurseID) REFERENCES Nurse(NurseID)
    @Id
    @GeneratedValue
    private Long takeCareID;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "nurseID",referencedColumnName = "nurseId")
    private Nurse nurseID;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "patientID",referencedColumnName = "patientId")
    private Patient patientID;
    private LocalDate Date;

    public TakeCare(Patient patient, Nurse nurse, LocalDate date) {
        this.setNurseID(nurse);
        this.setPatientID(patient);
        this.Date = date;
    }

    public void setPatientID(Patient patient) {
        this.patientID =  patient;
    }

    public void setNurseID(Nurse nurse) {
        this.nurseID = nurse;
    }

    public Long getNurseID() {
        return this.nurseID.getNurseId();
    }

    public Long getPatientID() {
        return this.patientID.getPatientId();
    }
}
