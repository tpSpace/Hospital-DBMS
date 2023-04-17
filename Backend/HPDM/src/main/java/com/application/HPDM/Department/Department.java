package com.application.HPDM.Department;
import com.application.HPDM.Doctor.Doctor;
import com.application.HPDM.Nurse.Nurse;
import com.application.HPDM.Staff.Staff;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Department {
    @Id
    @SequenceGenerator(
            name = "department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_sequence"
    )
    @Column(
            name ="departmentID",
            updatable = false
    )
    private Long departmentID;
    @Column(
            name = "departmentName",
            nullable = false
    )
    private String departmentName;

    @OneToMany(mappedBy = "departmentID")
    private List<Doctor>  doctors;
    @OneToMany(mappedBy = "departmentID")
    private List<Nurse>  nurses;
    @OneToMany(mappedBy = "departmentID")
    private List<Staff>  staff;

    public Department(){};

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getDepartmentName() {
        return departmentName;
    }

    public Long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Long departmentID) {
        this.departmentID = departmentID;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "DepartmentID=" + departmentID +
                ", DepartmentName='" + departmentName + '\'' +
                '}';
    }

}
