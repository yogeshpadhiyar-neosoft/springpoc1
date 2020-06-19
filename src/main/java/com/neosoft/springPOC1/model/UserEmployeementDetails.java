package com.neosoft.springPOC1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEmployeementDetails {
    @OneToOne
    @JsonBackReference
    private UserMaster userMaster;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userEmployeeId;
    private String department;
    @Pattern(regexp = "^([a-z0-9_\\-\\.]+)@([a-z0-9_\\-\\.]+)\\.([a-z]{2,5})$", message = "Enter Valid Email ID")
    private String workEmailId;
//    @Pattern(regexp = "^[1-9]([0-9]){9}",message = "Enter Valid Mobile Number.")
    private String workMobileNo;
    private long salary;
    private Date employeeJoinDate;
    private int experience;

}
