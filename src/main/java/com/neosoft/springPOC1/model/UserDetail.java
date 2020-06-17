package com.neosoft.springPOC1.model;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surName;
    @Column(unique = true)
    @Pattern(regexp = "^([a-z0-9_\\-\\.]+)@([a-z0-9_\\-\\.]+)\\.([a-z]{2,5})$", message = "Enter Valid Email ID")
    private String emailID;
    @Pattern(regexp = "^[1-9]([0-9]){9}",message = "Enter Valid Mobile Number.")
    private String mobileNo;
    private Date DOB;
    private Date joinDate;
    @Digits(integer = 6, fraction = 0)
    private int pinCode;
    private boolean status = true;

}
