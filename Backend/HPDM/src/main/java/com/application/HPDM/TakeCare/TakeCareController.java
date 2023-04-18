package com.application.HPDM.TakeCare;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TakeCareController {
    @Autowired
    private TakeCareService takeCareService;
    private final Logger LOGGER = LoggerFactory.getLogger(TakeCare.class);
    @PostMapping("/takeCare")
    public TakeCare saveTakeCare(@Valid @RequestBody TakeCare takeCare) {
        LOGGER.info("Inside saveTakeCare of TakeCareController");
        return takeCareService.saveTakeCare(takeCare);
    }

    @GetMapping("/takeCare")
    public List<TakeCare> fetchTakeCareList() {
        return takeCareService.fetchTakeCareList();
    }

    @GetMapping("/takeCare/{doctorId}")
    public TakeCare fetchTakeCareByDoctorID(@PathVariable("doctorId") Long doctorId) {
        return takeCareService.fetchTakeCareByDoctorID(doctorId);
    }

    @GetMapping("/takeCare/{patientId}")
    public TakeCare fetchTakeCareByPatientID(@PathVariable("patientId") Long patientId) {
        return takeCareService.fetchTakeCareByPatientID(patientId);
    }
}
