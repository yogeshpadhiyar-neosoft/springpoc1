package com.neosoft.springPOC1.responsepojo;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEmployeementDetailsPojo {
    private String department;
    private String workEmailId;
    private String workMobileNo;
    private long salary;
    private Date employeeJoinDate;
    private int experience;
}
