package com.application.HPDM.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
//@RequestMapping
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }

    @GetMapping(path = "/departments")
    public List<Department> getDepartment(){
        return departmentService.getDepartment();
    }
    @GetMapping(path = "/department/{departmentID}")
    public Department getDepartmentById(@PathVariable("departmentID") Long id){
        return departmentService.findDepartmentById(id);
    }

    @PostMapping(path = "/department")
    public void registerNewDepartment(@RequestBody Department department){
        departmentService.addNewDepartment(department);
    }
    @DeleteMapping(path= "/department/{departmentID}")
    public void deleteDepartment(@PathVariable("departmentID") Long departmentID){
        departmentService.deleteDepartment(departmentID);
    }
}
