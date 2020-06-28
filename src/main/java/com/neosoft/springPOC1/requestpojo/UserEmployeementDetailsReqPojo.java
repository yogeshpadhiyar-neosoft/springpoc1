package com.neosoft.springPOC1.requestpojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEmployeementDetailsReqPojo {
    private String department;
    private String workEmailId;
    private String workMobileNo;
    private long salary;
    private Date employeeJoinDate;
    private int experience;
}
