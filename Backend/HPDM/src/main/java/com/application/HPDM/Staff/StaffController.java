package com.application.HPDM.Staff;


import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StaffController {
    @Autowired
    private StaffService staffService;
    private final Logger LOGGER = LoggerFactory.getLogger(Staff.class);
    @PostMapping("/staff") //Dua du lieu len database
    public Staff saveStaff (@Valid @RequestBody Staff staff) {
        LOGGER.info("Inside saveStaff of StaffController");
        return staffService.saveStaff(staff);
    }
    @GetMapping("/staff") //Coi du lieu
    public List<Staff> fetchStaffList() {return staffService.fetchStaffList();}
    @GetMapping("/staff/{id}")// Coi du lieu theo ID
    public Staff fetchStaffByID(@PathVariable("id") Long staffID) throws StaffNotFoundException {
        return staffService.fetchStaffByID(staffID);
    }
    @GetMapping("/staff/name/{name}")
    public Staff fetchStaffByName(@PathVariable("name") String staffName) {
        return staffService.fetchStaffByName(staffName);
    }
    @DeleteMapping("/staff/{id}")
    public String deleteStaffByID(@PathVariable("id") Long staffID) {
        staffService.deleteStaffByID(staffID);
        return "Staff has been deleted";
    }
    @PutMapping("/staff/{id}")
    public Staff updateStaff(@PathVariable("id") Long staffID,
                             @RequestBody Staff staff) {
        return staffService.updateStaff(staffID,staff);
    }
}
