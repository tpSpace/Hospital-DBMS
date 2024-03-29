package com.application.HPDM.Login;


import com.application.HPDM.Doctor.DoctorRepository;
import com.application.HPDM.Nurse.NurseRepository;
import com.application.HPDM.Patient.PatientRepository;
import com.application.HPDM.Staff.StaffRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<LoginResponse> patientLogin(@RequestBody LoginRequest loginRequest){
        Long patientEmail = patientRepository.findIdByEmail(loginRequest.getEmail());
        List<Long> patientPassword = patientRepository.findIdByPassword(loginRequest.getPassword());

        Long doctorEmail = doctorRepository.findIdByEmail(loginRequest.getEmail());
        List<Long> doctorPassword = doctorRepository.findIdByPassword(loginRequest.getPassword());

        Long nurseEmail = nurseRepository.findIdByEmail(loginRequest.getEmail());
        List<Long> nursePassword = nurseRepository.findIdByPassword(loginRequest.getPassword());

        Long staffEmail = staffRepository.findIdByEmail(loginRequest.getEmail());
        List<Long> staffPassword = staffRepository.findIdByPassword(loginRequest.getPassword());

        if(patientEmail != null && patientPassword != null){
            if(contains(patientPassword, patientEmail)){
                return new ResponseEntity<LoginResponse>(new LoginResponse("Patient", patientEmail.toString()), HttpStatus.OK);
            }
        } else if(staffEmail != null && staffPassword != null){
            if(contains(staffPassword, staffEmail)){
                return new ResponseEntity<LoginResponse>(new LoginResponse("Staff", staffEmail.toString()), HttpStatus.OK);
            }
        } else if(doctorEmail != null && doctorPassword != null){
            if(contains(doctorPassword, doctorEmail)){
                return new ResponseEntity<LoginResponse>(new LoginResponse("Doctor", doctorEmail.toString()), HttpStatus.OK);
            }
        } else if(nurseEmail != null && nursePassword != null){
            if(contains(nursePassword, nurseEmail)){
                return new ResponseEntity<LoginResponse>(new LoginResponse("Nurse", nurseEmail.toString()), HttpStatus.OK);
            }
        }


        return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
    }
    static boolean contains(List<Long> list, Long item) {
        for (Long n : list) {
            if (item.equals(n)) {
                return true;
            }
        }
        return false;
    }
}
