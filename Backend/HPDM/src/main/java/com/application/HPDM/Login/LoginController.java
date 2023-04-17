package com.application.HPDM.Login;

import com.application.HPDM.Doctor.Doctor;
import com.application.HPDM.Doctor.DoctorController;
import com.application.HPDM.Patient.Patient;
import com.application.HPDM.Patient.PatientController;
import com.application.HPDM.Patient.PatientRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@CrossOrigin("*")
public class LoginController {

//    @Autowired
//    private AuthenticationManager authenticationManager;
//    private JwtToken
//    @PostMapping(path = "/doctor/login")
//    public ResponseEntity<Doctor> doctorLogin(@RequestBody LoginRequest loginRequest){
//        final Authentication authentication =
//    }
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientController patientController;


    @PostMapping(path = "/login")
    public ResponseEntity<String> patientLogin(@RequestBody LoginRequest loginRequest){
        Long Email = patientRepository.findIdByEmail(loginRequest.getEmail());
        Long Password = patientRepository.findIdByPassword(loginRequest.getPassword());
        if(Email.equals(Password) && Email != null && Password != null){
            return ResponseEntity.ok("Login Successful");
        }
        return ResponseEntity.badRequest()
                .body("Year of birth cannot be in the future");
    }
}
