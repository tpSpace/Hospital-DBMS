package com.application.HPDM.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findDoctorByDoctorPhoneNum(String doctorPhoneNum);
    Optional<Doctor> findDoctorByDoctorEmail(String doctorEmail);

    @Query("SELECT d.doctorId FROM Doctor d WHERE d.doctorEmail = ?1")
    public  Long findIdByEmail(String doctorEmail);

    //query by password and return
    @Query("SELECT d.doctorId FROM Doctor d WHERE d.doctorPassword = ?1")
    public List<Long> findIdByPassword(String doctorPassword);
}
