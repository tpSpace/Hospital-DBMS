package com.application.HPDM.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        Optional<Doctor> optionalDoctor = doctorRepository.findDoctorByDoctorPhoneNum(doctor.getPhoneNum());
        if(optionalDoctor.isPresent()){
            throw new IllegalStateException("The phone number is taken");
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

    @Transactional
    public void updateDoctor(Long doctorId, String name, String phoneNum){
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalStateException("doctor with id: " + doctorId + " does not exists"));

        if(name != null && name.length() > 0 && !Objects.equals(doctor.getName(), name)){
            doctor.setName(name);
        }
        if(phoneNum != null && phoneNum.length() > 0 && !Objects.equals(doctor.getPhoneNum(), phoneNum)){
            Optional<Doctor> optionalDoctor = doctorRepository.findDoctorByDoctorPhoneNum(phoneNum);
            if(optionalDoctor.isPresent()){
                throw new IllegalStateException("phone number is taken");
            }
            doctor.setPhoneNum(phoneNum);
        }
    }

}
