package com.application.HPDM.Nurse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {
    public Nurse findByNurseNameIgnoreCase(String nurseName);

    @Query("SELECT n.nurseId FROM Nurse n WHERE n.nurseEmail = ?1")
    public  Long findIdByEmail(String email);
    @Query("SELECT n.nurseId FROM Nurse n WHERE n.nursePassword = ?1")
    public List<Long> findIdByPassword(String password);
}
