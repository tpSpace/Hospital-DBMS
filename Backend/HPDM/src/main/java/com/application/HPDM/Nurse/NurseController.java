package com.application.HPDM.Nurse;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NurseController {
    @Autowired
    private NurseService nurseService;
    private final Logger LOGGER = LoggerFactory.getLogger(Nurse.class);
    @PostMapping("/nurse") //Dua du lieu len database
    public Nurse saveNurse (@Valid @RequestBody Nurse nurse) {
        LOGGER.info("Inside saveNurse of NurseController");
        return nurseService.saveNurse(nurse);
    }
    @GetMapping("/nurse") //Coi du lieu
    public List<Nurse> fetchNurseList() {return nurseService.fetchNurseList();}
    @GetMapping("/nurse/{id}")// Coi du lieu theo ID
    public Nurse fetchNurseByID(@PathVariable("id") Long nurseID)  {
        return nurseService.fetchNurseByID(nurseID);
    }
    @GetMapping("/nurse/name/{name}")
    public Nurse fetchNurseByName(@PathVariable("name") String nurseName) {
        return nurseService.fetchNurseByName(nurseName);
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
