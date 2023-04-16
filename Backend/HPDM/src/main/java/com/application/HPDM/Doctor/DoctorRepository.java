package com.application.HPDM.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findDoctorByDoctorPhoneNum(String doctorPhoneNum);
    Optional<Doctor> findDoctorByDoctorEmail(String doctorEmail);
}
