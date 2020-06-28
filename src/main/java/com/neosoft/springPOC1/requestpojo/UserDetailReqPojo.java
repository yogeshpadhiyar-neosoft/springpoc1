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
public class UserDetailReqPojo {
    private String name;
    private String surName;
    private String emailId;
    private String mobileNo;
    private Date dateOfBirth;
    private Date joinDate;
    private int pinCode;
}
