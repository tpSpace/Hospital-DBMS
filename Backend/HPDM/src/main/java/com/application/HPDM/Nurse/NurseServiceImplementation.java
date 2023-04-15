package com.application.HPDM.Nurse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service

public class NurseServiceImplementation implements NurseService{
    @Autowired
    private NurseRepository nurseRepository;
    @Override
    public Nurse saveNurse(Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    @Override
    public Nurse fetchNurseByID(Long nurseID) {
        Optional<Nurse> nurse =
                nurseRepository.findById(nurseID);

        return nurse.get();
    }

    @Override
    public Nurse fetchNurseByName(String nurseName) {
        return nurseRepository .findByNurseNameIgnoreCase(nurseName);
    }

    @Override
    public void deleteNurseByID(Long nurseID) {
        nurseRepository.deleteById(nurseID);
    }

    @Override
    public List<Nurse> fetchNurseList() {
        return nurseRepository.findAll();
    }

    @Override
    public Nurse updateNurse(Long nurseID, Nurse nurse) {
        Nurse nurseDb = nurseRepository.findById(nurseID).get();

        if(Objects.nonNull(nurse.getNurseName()) &&
        !"".equalsIgnoreCase(nurse.getNurseName())) {
            nurseDb.setNurseName(nurse.getNurseName());
        }
        if(Objects.nonNull(nurse.getNursePhone()) &&
                !"".equalsIgnoreCase(nurse.getNursePhone())) {
            nurseDb.setNursePhone(nurse.getNursePhone());
        }
        return nurseRepository.save(nurseDb);
    }
}
