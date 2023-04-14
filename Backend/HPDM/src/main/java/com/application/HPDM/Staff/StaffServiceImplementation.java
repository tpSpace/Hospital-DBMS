package com.application.HPDM.Staff;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImplementation implements StaffService{
    @Autowired
    private StaffRepository staffRepository;
    @Override
    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public List<Staff> fetchStaffList() {
        return staffRepository.findAll();
    }

    @Override
    public Staff fetchStaffByID(Long staffID) {
        Optional<Staff> staff =
                staffRepository.findById(staffID);

        return staff.get();
    }

    @Override
    public void deleteStaffByID(Long staffID) {
        staffRepository.deleteById(staffID);
    }

    @Override
    public Staff updateStaff(Long staffID, Staff staff) {

        return null;
    }

    @Override
    public Staff fetchStaffByName(String staffName) {

        return staffRepository.findByStaffNameIgnoreCase(staffName);
    }
}
