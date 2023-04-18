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
    @GetMapping(path = "/incharge/{id}")
    public Incharge getShiftById(@PathVariable("inchargeID") Long id){
        return inchargeService.findInchargeById(id);
    }

    @PostMapping(path = "/incharge/add")
    public void registerNewShift(@RequestBody Incharge incharge) {
        inchargeService.addNewShift(incharge);
    }
}
