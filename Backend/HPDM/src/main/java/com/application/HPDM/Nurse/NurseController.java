package com.application.HPDM.Nurse;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
public class NurseController {
    @Autowired
    private NurseService nurseService;
    private final Logger LOGGER = LoggerFactory.getLogger(Nurse.class);
    @PostMapping("/nurse") //Dua du lieu len database
    public Nurse saveNurse (@Valid @RequestBody Nurse nurse) {
        LOGGER.info("Inside saveStaff of StaffController");
        return nurseService.saveNurse(nurse);
    }
    @GetMapping("/nurse") //Coi du lieu
    public List<Nurse> fetchStaffList() {return nurseService.fetchNurseList();}
    @GetMapping("/nurse/{id}")// Coi du lieu theo ID
    public Nurse fetchStaffByID(@PathVariable("id") Long staffID)  {
        return nurseService.fetchNurseByID(staffID);
    }
    @GetMapping("/nurse/name/{name}")
    public Nurse fetchStaffByName(@PathVariable("name") String staffName) {
        return nurseService.fetchNurseByName(staffName);
    }
    @DeleteMapping("/nurse/{id}")
    public String deleteNurseByID(@PathVariable("id") Long nurseID) {
        nurseService.deleteNurseByID(nurseID);
        return "Nurse has been deleted";
    }
    @PutMapping("/nurse/{id}")
    public Nurse updateNurse(@PathVariable("id") Long nurseID,
                             @RequestBody Nurse nurse) {
        return nurseService.updateNurse(nurseID,nurse);
    }
}
