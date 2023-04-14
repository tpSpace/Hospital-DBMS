package com.application.HPDM.Staff;


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
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long staffId;
    @NotBlank(message = "Please enter nurse name")
    @Length(max = 50, min = 1)
    private String staffName;
    @NotBlank(message = "Please enter DoB")
    private Date staffDoB;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departmentID", referencedColumnName = "staffDeparmentID")
    private Long staffDepartmentID;
    @NotBlank(message = "Please enter phone number")
    @Length(max = 15, min = 1)
    private String staffPhone;
}
