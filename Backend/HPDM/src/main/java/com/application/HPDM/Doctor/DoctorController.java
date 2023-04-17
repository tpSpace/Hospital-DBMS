package com.application.HPDM.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @GetMapping(path = "/doctors")
    public List<Doctor> getDoctors(){
        return doctorService.getDoctors();
    }

    @GetMapping(path = "doctor/{doctorId}")
    public Doctor getDoctorById(@PathVariable("doctorId") Long id){
        return doctorService.findDoctorById(id);
    }

    @PostMapping
    public void registerNewDoctor(@RequestBody Doctor doctor){
        doctorService.addNewDoctor(doctor);
    }

    @PostMapping(path = "doctor/login")
    public boolean loginDoctor(@RequestBody String doctorEmail, @RequestBody String doctorPassword){
        return doctorService.login(doctorEmail, doctorPassword);
    }

    @DeleteMapping(path = "doctor/{doctorId}")
    public void deleteDoctor(@PathVariable("doctorId") Long doctorId){
        doctorService.deleteDoctor(doctorId);
    }

    @PutMapping(path = "doctor/{doctorId}")
    public void updateDoctor(@PathVariable("doctorId") Long doctorId,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String phoneNum,
                             @RequestParam(required = false) String email){
        doctorService.updateDoctor(doctorId, name, phoneNum, email);
    }
}
