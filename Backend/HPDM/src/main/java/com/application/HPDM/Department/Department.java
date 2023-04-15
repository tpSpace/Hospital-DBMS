package com.application.HPDM.Department;
import jakarta.persistence.*;

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
    private Long DepartmentID;
    @Column(
            name = "departmentName",
            nullable = false
    )
    private String departmentName;

    public Department(){};
    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "DepartmentID=" + DepartmentID +
                ", DepartmentName='" + departmentName + '\'' +
                '}';
    }
}
