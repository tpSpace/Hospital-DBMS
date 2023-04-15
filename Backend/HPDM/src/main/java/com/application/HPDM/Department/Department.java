package com.application.HPDM.Department;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

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
            name ="DepartmentID",
            updatable = false
    )
    private Long DepartmentID;
    @Column(
            name = "DepartmentName",
            nullable = false
    )
    private String DepartmentName;

    public Department(){};
    public Department(String departmentName) {
        DepartmentName = departmentName;
    }
    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "DepartmentID=" + DepartmentID +
                ", DepartmentName='" + DepartmentName + '\'' +
                '}';
    }
}
