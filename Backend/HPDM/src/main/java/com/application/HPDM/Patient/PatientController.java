package com.application.HPDM.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PatientController {
    @Autowired
    private final PatientRepository patientRepository;
    @Autowired
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }
    public Long findPatientIdByPatientEmail(String patientEmail) {
        return patientRepository.findIdByEmail(patientEmail);
    }
    public Long findPatientIdByPatientPhone(String patientPhone) {
        return patientRepository.findIdByPassword(patientPhone);
    }
    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    }

    @PostMapping("/createPatients")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @PutMapping("/patients/{id}")
    public Patient updatePatient(@RequestBody Patient newPatient, @PathVariable Long id) {
        return patientRepository.findById(id).map(patient -> {
            patient.setPatientFirstName(newPatient.getPatientFirstName());
            patient.setPatientLastName(newPatient.getPatientLastName());
            patient.setPatientGender(newPatient.getPatientGender());
            patient.setPatientDob(newPatient.getPatientDob());
            patient.setPatientMedicalRecord(newPatient.getPatientMedicalRecord());
            patient.setPatientPhone(newPatient.getPatientPhone());
            patient.setPatientEmail(newPatient.getPatientEmail());
            return patientRepository.save(patient);
        }).orElseThrow(()-> new UserNotFoundException(id));
    }

}
