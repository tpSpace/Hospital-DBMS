package com.application.HPDM.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository ){
        this.departmentRepository =departmentRepository;
    }
    public List<Department> getDepartment(){
        return departmentRepository.findAll();
    }

    public void addNewDepartment(Department department){
        Optional<Department> departmentOptional=
<<<<<<< HEAD
            departmentRepository.findDepartmentBydepartmentName(department.getDepartmentName());
=======
            departmentRepository.findDepartmentByDepartmentName(department.getDepartmentName());
>>>>>>> master
        if(departmentOptional.isPresent()){
            throw new IllegalStateException("Department name already exists");
        }
        departmentRepository.save(department);
    }

<<<<<<< HEAD
    public void deleteDepartment(Long departmentID){
        boolean exists = departmentRepository.existsById(departmentID);
        if(!exists){
            throw new IllegalStateException("Department with id" + departmentID + "doesn't exist");
        }
        departmentRepository.deleteById(departmentID);
=======
    public void deleteDepartment(Long Departmentid){
        boolean exists = departmentRepository.existsById(Departmentid);
        if(!exists){
            throw new IllegalStateException("Department with id" + Departmentid + "doesn't exist");
        }
        departmentRepository.deleteById(Departmentid);
>>>>>>> master
    }
}
