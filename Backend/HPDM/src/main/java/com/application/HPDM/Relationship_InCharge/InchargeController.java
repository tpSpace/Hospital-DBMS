package com.application.HPDM.Relationship_InCharge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class InchargeController {

    private final InchargeService inchargeService;

    @Autowired
    public InchargeController(InchargeService inchargeService){
        this.inchargeService = inchargeService;
    }

    @GetMapping(path = "/incharge")
    public List<Incharge> getShift(){
        return inchargeService.getIncharge();
    }
    @GetMapping(path = "/incharge/{inchargeId}")
    public Incharge getShiftById(@PathVariable("inchargeId") Long id){
        return inchargeService.findInchargeById(id);
    }

    @GetMapping(path = "/incharge/nurse/{nurseId}")
    public List<Incharge> getShiftByNurseID(@PathVariable("nurseId") Long nurseId){
        return inchargeService.findShiftbyNurseID(nurseId);
    }

    @GetMapping(path = "/incharge/room/{roomId}")
    public List<Incharge> getShiftByRoomID(@PathVariable("roomId") Long roomID){
        return inchargeService.findShiftbyRoomID(roomID);
    }
    @PostMapping(path = "/incharge/add")
    public void registerNewShift(@RequestBody Incharge incharge) {
        inchargeService.addNewShift(incharge);
    }
}
