package com.application.HPDM.TakeCare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<TakeCare> fetchTakeCareByPatientID(Long patientId) {
        List<TakeCare> takeCareList = new ArrayList<>();

        for(TakeCare a : takeCareRespository.findAll()){
            if(a.getPatientID() == patientId){
                takeCareList.add(a);
            }
        }
        return takeCareList;
    }

    public List<TakeCare> fetchTakeCareByNurseID(Long nurseId) {
        List<TakeCare> takeCareList = new ArrayList<>();

        for(TakeCare a : takeCareRespository.findAll()){
            if(a.getNurseID() == nurseId){
                takeCareList.add(a);
            }
        }
        return takeCareList;
    }
}
