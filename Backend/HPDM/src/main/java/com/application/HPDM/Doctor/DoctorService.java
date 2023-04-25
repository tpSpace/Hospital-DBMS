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

    public Doctor findDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalStateException("Doctor with id: " + doctorId + " does not exists"));
    }

    public void addNewDoctor(Doctor doctor){
        Optional<Doctor> optionalDoctor = doctorRepository.findDoctorByDoctorPhoneNum(doctor.getDoctorPhoneNum());
        if(optionalDoctor.isPresent()){
            throw new IllegalStateException("The phone number is taken");
        }
        optionalDoctor = doctorRepository.findDoctorByDoctorEmail(doctor.getDoctorEmail());
        if(optionalDoctor.isPresent()){
            throw new IllegalStateException("email is taken");
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
    public Doctor updateDoctor(Long doctorId, Doctor doctor){
        Doctor updateDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalStateException("doctor with id: " + doctorId + " does not exists"));

        String name = doctor.getDoctorName();
        if(name != null && name.length() > 0 &&
                !Objects.equals(updateDoctor.getDoctorName(), name)){
            updateDoctor.setDoctorName(name);
        }

        String phoneNum = doctor.getDoctorPhoneNum();
        if(phoneNum != null && phoneNum.length() > 0 &&
                !Objects.equals(updateDoctor.getDoctorPhoneNum(), phoneNum)){
            Optional<Doctor> optionalDoctor = doctorRepository.findDoctorByDoctorPhoneNum(phoneNum);
            if(optionalDoctor.isPresent()){
                throw new IllegalStateException("phone number is taken");
            }
            updateDoctor.setDoctorPhoneNum(phoneNum);
        }

        String email = doctor.getDoctorEmail();
        if(email != null && email.length() > 0 &&
                !Objects.equals(updateDoctor.getDoctorEmail(), email)){
            Optional<Doctor> optionalDoctor = doctorRepository.findDoctorByDoctorEmail(email);
            if(optionalDoctor.isPresent()){
                throw new IllegalStateException("email is taken");
            }
            updateDoctor.setDoctorEmail(email);
        }
        return doctorRepository.save(updateDoctor);
    }

}
