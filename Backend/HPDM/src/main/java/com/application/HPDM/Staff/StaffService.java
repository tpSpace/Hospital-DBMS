package com.hung.testspring.service;

import com.hung.testspring.entity.Staff;
import com.hung.testspring.error.DepartmentNotFoundException;
import com.hung.testspring.error.StaffNotFoundException;

import java.util.List;


public interface StaffService {
    public Staff saveStaff(Staff staff);
    List<Staff> fetchStaffList();
    public Staff fetchStaffByID(Long staffID) throws StaffNotFoundException;

    public void deleteStaffByID(Long staffID);

    public Staff updateStaff(Long staffID, Staff staff);

    public Staff fetchStaffByName(String staffName);
}
