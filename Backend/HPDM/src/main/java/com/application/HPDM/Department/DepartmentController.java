package com.application.HPDM.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }

    @GetMapping
    public List<Department> getDepartment(){
        return departmentService.getDepartment();
    }

    @PostMapping
    public void registerNewDepartment(@RequestBody Department department){
        departmentService.addNewDepartment(department);
    }

    @DeleteMapping(path= "{departmentID}")
    public void deleteDepartment(@PathVariable("departmentID") Long departmentid){
        departmentService.deleteDepartment(departmentid);
    }
}
