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
    public void updateDoctor(Long doctorId, String name, String phoneNum, String email){
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalStateException("doctor with id: " + doctorId + " does not exists"));

        if(name != null && name.length() > 0 && !Objects.equals(doctor.getDoctorName(), name)){
            doctor.setDoctorName(name);
        }
        if(phoneNum != null && phoneNum.length() > 0 && !Objects.equals(doctor.getDoctorPhoneNum(), phoneNum)){
            Optional<Doctor> optionalDoctor = doctorRepository.findDoctorByDoctorPhoneNum(phoneNum);
            if(optionalDoctor.isPresent()){
                throw new IllegalStateException("phone number is taken");
            }
            doctor.setDoctorPhoneNum(phoneNum);
        }
        if(email != null && email.length() > 0 && !Objects.equals(doctor.getDoctorEmail(), email)){
            Optional<Doctor> optionalDoctor = doctorRepository.findDoctorByDoctorEmail(email);
            if(optionalDoctor.isPresent()){
                throw new IllegalStateException("email is taken");
            }
            doctor.setDoctorEmail(email);
        }
    }

    public boolean login(String email, String password) {
        Optional<Doctor> optionalDoctorEmail = doctorRepository.findDoctorByDoctorEmail(email);
        Optional<Doctor> optionalDoctorPassword = doctorRepository.findDoctorByDoctorPassword(password);
        boolean isSuccess = false;
        if(doctorRepository.findById(optionalDoctorEmail.get().getDoctorId()) == doctorRepository.findById(optionalDoctorPassword.get().getDoctorId())){
            isSuccess = true;
        }else{
            if (doctorRepository.findDoctorByDoctorEmail(email).isEmpty()){
                throw new IllegalStateException("Can not find doctor email");
            }
            if(doctorRepository.findDoctorByDoctorPassword(password).isEmpty()){
                throw new IllegalStateException("The password is invalid");
            }
        }

        return isSuccess;
    }
}
