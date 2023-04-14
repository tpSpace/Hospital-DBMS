package com.hung.testspring.repository;

import com.hung.testspring.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    public Staff findByStaffNameIgnoreCase(Spring staffName);
}
