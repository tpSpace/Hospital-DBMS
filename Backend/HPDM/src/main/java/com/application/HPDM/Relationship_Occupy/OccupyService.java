package com.application.HPDM.Relationship_Occupy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;



@Service
public class OccupyService {
    private final OccupyRepository occupyRepository;
    @Autowired
    public OccupyService(OccupyRepository occupyRepository){
        this.occupyRepository = occupyRepository;
    }

    public List<Occupy> getOccupy(){
        return occupyRepository.findAll();
    }

    public Occupy addNewOccupation(Occupy occupy){
        return occupyRepository.save(occupy);
    }
    @Transactional
    public Occupy updateOccupationDateLeave(Long occupyID, Occupy occupy){
        Occupy updateOccupy = occupyRepository.findById(occupyID).
                orElseThrow(() -> new IllegalStateException("can't find occupation"));
        if (updateOccupy.getDateLeave() != null) {
            throw new IllegalStateException("Patient already left");
        }
        updateOccupy.setDateLeave(occupy.getDateLeave());
        return occupyRepository.save(updateOccupy);
    }
    public Occupy findOccupationById(Long id) {
        return occupyRepository.findById(id).get();
    }
    public void deleteOccupation(Long occupyID) {
        boolean exists = occupyRepository.existsById(occupyID);
        if (!exists) {
            throw new IllegalStateException("Occupation with id" + occupyID+ "doesn't exist");
        }
        occupyRepository.deleteById(occupyID);
    }
    public List<Occupy> findOccupationByPatientID(Long patientId){
        List<Occupy> occupyList = new ArrayList<>();

        for(Occupy a: occupyRepository.findAll() ){
            if(a.getPatientID() == patientId){
                occupyList.add(a);
            }
        }
        return occupyList;
    }

    public List<Occupy> findOccupationByRoomID(Long roomId){
        List<Occupy> occupyList = new ArrayList<>();

        for(Occupy a: occupyRepository.findAll() ){
            if(a.getRoomID() == roomId){
                occupyList.add(a);
            }
        }
        return occupyList;
    }
}
