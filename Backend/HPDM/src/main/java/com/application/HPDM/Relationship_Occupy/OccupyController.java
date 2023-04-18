package com.application.HPDM.Relationship_Occupy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
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
    @PutMapping(path = "/occupy/{id}")
    public Occupy updateOccupation(@PathVariable("id") Long occupyID,
                                  @RequestBody Occupy occupy){
        return occupyService.updateOccupationDateLeave(occupyID, occupy);
    }

    @DeleteMapping(path= "/occupy/{id}")
    public void deleteOccupation(@PathVariable("id") Long occupyID){
        occupyService.deleteOccupation(occupyID);
    }
}
