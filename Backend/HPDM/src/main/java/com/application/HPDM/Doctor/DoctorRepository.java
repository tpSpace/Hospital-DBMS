package com.application.HPDM.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import javax.print.Doc;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findDoctorByDoctorPhoneNum(String doctorPhoneNum);
    Optional<Doctor> findDoctorByDoctorEmail(String doctorEmail);
    Optional<Doctor> findDoctorByDoctorPassword(String doctorPassword);

    @Query("SELECT d.doctorId FROM Doctor d WHERE d.doctorEmail = ?1")
    public  Long findIdByEmail(String email);
    @Query("SELECT d.doctorId FROM Doctor d WHERE d.doctorPassword = ?1")
    public Long findIdByPassword(String password);

}
