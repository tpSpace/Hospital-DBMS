package com.application.HPDM.Staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface StaffRepository extends JpaRepository<Staff, Long> {
    public Staff findByStaffNameIgnoreCase(String staffName);

    @Query("SELECT s.staffId FROM Staff s WHERE s.staffEmail = ?1")
    public  Long findIdByEmail(String email);
    @Query("SELECT s.staffId FROM Staff s WHERE s.staffPassword = ?1")
    public Long findIdByPassword(String password);
}
