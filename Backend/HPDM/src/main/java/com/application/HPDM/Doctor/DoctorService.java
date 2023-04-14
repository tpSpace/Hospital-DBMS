package com.application.HPDM.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    public void addNewDoctor(Doctor doctor){
        boolean isExist = doctorRepository.existsById(doctor.getId());
        if(isExist){
            throw new IllegalStateException("The doctor is already existed");
        }
        doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long doctorID){
        boolean isExist = doctorRepository.existsById(doctorID);
        if(!isExist){
            throw new IllegalStateException("The doctor with id " + doctorID + " does not exists");
        }
        doctorRepository.deleteById(doctorID);
    }

}
