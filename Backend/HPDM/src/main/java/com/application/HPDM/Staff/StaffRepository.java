package com.application.HPDM.Staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    public Staff findByStaffNameIgnoreCase(String staffName);
}
