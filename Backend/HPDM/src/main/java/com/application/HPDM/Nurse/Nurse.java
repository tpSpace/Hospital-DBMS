package com.application.HPDM.Nurse;

import com.application.HPDM.Department.Department;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nurse {
//    nurseId SERIAL NOT NULL,
//    nurseName VARCHAR(50) NOT NULL,
//    nurseDob  DATE NOT NULL,
//    nurseDepartmentId INT NOT NULL REFERENCES Department(departmentId),
//    nursePhone VARCHAR(15),
//
//    PRIMARY KEY (nurseId)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nurseID;
    @NotBlank(message = "Please enter nurse name")
    @Length(max = 50, min = 1)
    private String nurseName;

//    @NotBlank(message = "Please enter DoB")
    private LocalDate nurseDoB;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "nurseDepartmentID", referencedColumnName = "departmentId")
    private Department departmentID;

    @NotBlank(message = "Please enter phone number")
    @Length(max = 15, min = 1)
    private String nursePhone;

    public Nurse(String nurseName, String nursePhone, LocalDate nurseDoB, Department departmentID) {
        this.nurseName = nurseName;
        this.nurseDoB = nurseDoB;
        this.nursePhone = nursePhone;
        this.setDepartmentId(departmentID);
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentID = departmentId;
    }
}