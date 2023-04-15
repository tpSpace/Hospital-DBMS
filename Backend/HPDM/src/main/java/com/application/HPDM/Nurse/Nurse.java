package com.application.HPDM.Nurse;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

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
    @NotBlank(message = "Please enter DoB")
    private Date nurseDoB;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departmentID", referencedColumnName = "nurseDeparmentID")
    private Long nurseDepartmentID;
    @NotBlank(message = "Please enter phone number")
    @Length(max = 15, min = 1)
    private String nursePhone;

}