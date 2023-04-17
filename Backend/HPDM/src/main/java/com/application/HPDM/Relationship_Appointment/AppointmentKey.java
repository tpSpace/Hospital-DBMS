//package com.application.HPDM.Relationship_Appointment;
//
//import com.application.HPDM.Doctor.Doctor;
//import com.application.HPDM.Patient.Patient;
//import jakarta.persistence.*;
//
//import java.io.Serializable;
//
//@Embeddable
//public class AppointmentKey implements Serializable {
//    @Column
//    private Long patientID;
//    @Column
//    private Long doctorID;
//
////    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
////    @MapsId("doctorId")
////    @JoinColumn(name = "doctorID",referencedColumnName = "doctorID")
////    private Doctor doctorID;
////    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
////    @MapsId("patientId")
////    @JoinColumn(name = "patientID",referencedColumnName = "patientID")
////    private Patient patientID;
//
//
//    public AppointmentKey(Long patientID, Long doctorID) {
//        this.patientID = patientID;
//        this.doctorID = doctorID;
//    }
//
//    public void setPatientID(Long patientID) {
//        this.patientID = patientID;
//    }
//
//    public void setDoctorID(Long doctorID) {
//        this.doctorID = doctorID;
//    }
//}
