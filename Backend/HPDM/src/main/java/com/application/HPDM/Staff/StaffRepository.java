package com.application.HPDM.Staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    @Query("SELECT s FROM Staff s WHERE s.staffName = ?1")
    public Staff findByStaffNameIgnoreCase(String staffName);

    @Query("SELECT s.staffId FROM Staff s WHERE s.staffEmail = ?1")
    public Long findIdByEmail(String email);
    @Query("SELECT s.staffId FROM Staff s WHERE s.staffPassword = ?1")
    public List<Long> findIdByPassword(String password);
}
