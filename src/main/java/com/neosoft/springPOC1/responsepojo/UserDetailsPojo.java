package com.neosoft.springPOC1.responsepojo;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetailsPojo {
    private String name;
    private String sunName;
    private String emailId;
    private String mobileNo;
    private Date dataOfBirth;
    private Date joinDate;
    private int pinCode;
}
