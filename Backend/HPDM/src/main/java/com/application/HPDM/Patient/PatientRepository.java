package com.application.HPDM.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PatientRepository extends JpaRepository<Patient, Long> {
    //query by email and reutrn id
    @Query("SELECT p.patientId FROM Patient p WHERE p.patientEmail = ?1")
    public  Long findIdByEmail(String email);

    //query by password and return
    @Query("SELECT p.patientId FROM Patient p WHERE p.patientPassword = ?1")
    public Long findIdByPassword(String password);
}
