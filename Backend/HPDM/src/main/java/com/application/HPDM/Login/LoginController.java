package com.application.HPDM.Login;

import com.application.HPDM.Doctor.DoctorController;
import com.application.HPDM.Doctor.DoctorRepository;
import com.application.HPDM.Patient.PatientController;
import com.application.HPDM.Patient.PatientRepository;
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

    @PostMapping(path = "/patient/login")
    public ResponseEntity<String> patientLogin(@RequestBody LoginRequest loginRequest){
        Long Email = patientRepository.findIdByEmail(loginRequest.getEmail());
        Long Password = patientRepository.findIdByPassword(loginRequest.getPassword());
        if(Email != null && Password != null){
            if(Email.equals(Password)){
                return ResponseEntity.ok("Login Successful");
            }

        }
        return ResponseEntity.badRequest()
                .body("Year of birth cannot be in the future");
    }

    @PostMapping(path = "/doctor/login")
    public ResponseEntity<String> doctorLogin(@RequestBody LoginRequest loginRequest){
        Long Email = doctorRepository.findIdByEmail(loginRequest.getEmail());
        Long Password = doctorRepository.findIdByPassword(loginRequest.getPassword());
        if(Email.equals(Password) && Email != null && Password != null){
            return ResponseEntity.ok("Login Successful as a doctor");
        }
        return ResponseEntity.badRequest()
                .body("Year of birth cannot be in the future");
    }
}
