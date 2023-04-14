package com.application.HPDM.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DepartmentRepository
        extends JpaRepository<Department,Long> {
//    @Query("SELECT d FROM Department d WHERE d.name=?1")
    Optional<Department> findDepartmentByName(String departmentName);
}
