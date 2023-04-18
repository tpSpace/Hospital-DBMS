package com.application.HPDM.Login;


import com.application.HPDM.Doctor.DoctorRepository;
import com.application.HPDM.Nurse.NurseRepository;
import com.application.HPDM.Patient.PatientRepository;
import com.application.HPDM.Staff.StaffRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private NurseRepository nurseRepository;



    @PostMapping(path = "/login")
    public ResponseEntity<String> patientLogin(@RequestBody LoginRequest loginRequest){
        Long patientEmail = patientRepository.findIdByEmail(loginRequest.getEmail());
        Long patientPassword = patientRepository.findIdByPassword(loginRequest.getPassword());

        Long doctorEmail = doctorRepository.findIdByEmail(loginRequest.getEmail());
        Long doctorPassword = doctorRepository.findIdByPassword(loginRequest.getPassword());

        Long nurseEmail = nurseRepository.findIdByEmail(loginRequest.getEmail());
        Long nursePassword = nurseRepository.findIdByPassword(loginRequest.getPassword());

        Long staffEmail = staffRepository.findIdByEmail(loginRequest.getEmail());
        Long staffPassword = staffRepository.findIdByPassword(loginRequest.getPassword());

        if(patientEmail != null && patientPassword != null){
            if(patientEmail.equals(patientPassword)){
                return ResponseEntity.ok("Patient");
            }
        } else if(staffEmail != null && staffPassword != null){
            if(staffEmail.equals(staffPassword)){
                return ResponseEntity.ok("Staff");
            }
        } else if(doctorEmail != null && doctorPassword != null){
            if(doctorEmail.equals(doctorPassword)){
                return ResponseEntity.ok("Doctor");
            }
        } else if(nurseEmail != null && nursePassword != null){
            if(nurseEmail.equals(nursePassword)){
                return ResponseEntity.ok("Nurse");
            }
        }


        return ResponseEntity.badRequest()
                .body("Email or Password is incorrect");
    }

}
