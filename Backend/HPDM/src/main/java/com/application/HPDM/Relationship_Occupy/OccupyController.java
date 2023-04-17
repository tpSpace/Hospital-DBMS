package com.application.HPDM.Relationship_Occupy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
//@RequestMapping
public class OccupyController {
    private OccupyService occupyService;

    @Autowired
    public OccupyController(OccupyService occupyService){
        this.occupyService = occupyService;
    }

    @GetMapping(path = "/occupy")
    public List<Occupy> getOccupy(){
        return occupyService.getOccupy();
    }

    @GetMapping(path = "/occupy/{ID}")
    public Occupy getOccupyById(@PathVariable("occupyID") Long id){
        return occupyService.findOccupationById(id);
    }

    @PostMapping(path = "/occupy/{ID}")
    public void updateOccupation(Occupy occupy, LocalDate date){
        if(occupy.getDateLeave() != null){
            throw new RuntimeException("Patient have aleady left");
        }
        occupy.setDateLeave(date);
    }

    @DeleteMapping(path= "/occupy/{ID}")
    public void deleteOccupation(@PathVariable("occupyID") Long occupyID){
        occupyService.deleteOccupation(occupyID);
    }
}
