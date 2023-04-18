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

    @PostMapping(path = "/occupy/add")
    public void registerNewOccupation(@RequestBody Occupy occupy){
        occupyService.addNewOccupation(occupy);
    }
    @PutMapping(path = "/occupy/update")
    public void updateOccupation(@PathVariable Long occupyID, LocalDate date){
        Occupy updateOccupy = occupyService.findOccupationById(occupyID);
        if (updateOccupy.getDateLeave() != null){
            throw new IllegalStateException("Patient already left");
        }
        else
            updateOccupy.setDateLeave(date);
        occupyService.updateOccupation(updateOccupy);
    }

    @DeleteMapping(path= "/occupy/{ID}")
    public void deleteOccupation(@PathVariable("occupyID") Long occupyID){
        occupyService.deleteOccupation(occupyID);
    }
}
