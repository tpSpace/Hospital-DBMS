package com.application.HPDM.Relationship_InCharge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InchargeService {
    private final InchargeRepository inchargeRepository;

    @Autowired
    public InchargeService(InchargeRepository inchargeRepository){
        this.inchargeRepository = inchargeRepository;
    }

    public List<Incharge> getIncharge(){
        return inchargeRepository.findAll();
    }

    public void addNewShift(Incharge incharge){
        inchargeRepository.save(incharge);
    }

    public Incharge findInchargeById(Long id) {
        return inchargeRepository.findById(id).get();
    }
    public List<Incharge> findShiftbyNurseID(Long nurseID) {
        List<Incharge> inchargeList = new ArrayList<>();

        for(Incharge a : inchargeRepository.findAll()){
            if(a.getNurseID() == nurseID){
                inchargeList.add(a);
            }
        }
        return inchargeList;
    }

    public List<Incharge> findShiftbyRoomID(Long roomID) {
        List<Incharge> inchargeList = new ArrayList<>();

        for(Incharge a : inchargeRepository.findAll()){
            if(a.getRoomID() == roomID){
                inchargeList.add(a);
            }
        }
        return inchargeList;
    }
    public void deleteShift(Long inchargeID) {
        boolean exists = inchargeRepository.existsById(inchargeID);
        if (!exists) {
            throw new IllegalStateException("This shift doesn't exists");
        }
        inchargeRepository.deleteById(inchargeID);
    }

}
