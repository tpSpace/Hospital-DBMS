package com.application.HPDM.TakeCare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class TakeCareServiceImplementation implements TakeCareService{
    @Autowired
    private TakeCareRespository takeCareRespository;
    @Override
    public TakeCare saveTakeCare(TakeCare takeCare) {
        return takeCareRespository.save(takeCare);
    }

    @Override
    public List<TakeCare> fetchTakeCareList() {
        return takeCareRespository.findAll();
    }

    @Override
    public TakeCare fetchTakeCareByPatientID(Long patientId) {
        Optional<TakeCare> takeCare =
                takeCareRespository.findById(patientId);
        return takeCare.get();
    }

    @Override
    public TakeCare fetchTakeCareByNurseID(Long nurseId) {
        Optional<TakeCare> takeCare =
                takeCareRespository.findById(nurseId);
        return takeCare.get();
    }
}
