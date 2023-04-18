package com.application.HPDM.Staff;

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
public class Staff {
//    staffId SERIAL NOT NULL,
//    staffName VARCHAR(50) NOT NULL,
//    staffDob  DATE NOT NULL,
//    staffDepartmentId int NOT NULL REFERENCES Department(departmentId),
//    staffPhone VARCHAR(15),
//
//    PRIMARY KEY (staffId)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffId;
    @NotBlank(message = "Please enter staff name")
    @Length(max = 50, min = 1)
    private String staffName;
//    @NotBlank(message = "Please enter DoB")
    private LocalDate staffDoB;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "staffDepartmentID", referencedColumnName = "departmentID")
    private Department departmentID;

    @NotBlank(message = "Please enter phone number")
    @Length(max = 15, min = 1)
    private String staffPhone;

    @NotBlank(message = "Please enter email")
    @Column(unique=true)
    @Length(max = 100, min = 1)
    private String staffEmail;

    @Length(max = 100, min = 1)
    private String staffPassword;

    public Staff(String name, LocalDate date, Department departmentID, String phone, String staffEmail, String staffPassword) {
        this.staffName = name;
        this.staffDoB = date;
        this.setDepartmentID(departmentID);
        this.staffPhone = phone;
        this.staffEmail = staffEmail;
        this.staffPassword = staffPassword;
    }

    public Long getStaffId() {
        return staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public LocalDate getStaffDoB() {
        return staffDoB;
    }

    public Long getDepartmentID() {
        return departmentID.getDepartmentID();
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setStaffDoB(LocalDate staffDoB) {
        this.staffDoB = staffDoB;
    }

    public void setDepartmentID(Department departmentID) {
        this.departmentID = departmentID;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }
}
