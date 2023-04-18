package com.application.HPDM.Relationship_Occupy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void addNewOccupation(Occupy occupy){
        occupyRepository.save(occupy);
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

    public void updateOccupation(Occupy occupy){
        deleteOccupation(occupy.getOccupyID());
        addNewOccupation(occupy);
    }
}
