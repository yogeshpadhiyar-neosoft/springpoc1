package com.neosoft.springPOC1.model;

import com.fasterxml.jackson.annotation.*;
import com.neosoft.springPOC1.Constant.Regex;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {

    @OneToOne
    @JsonBackReference
    private UserMaster userMaster;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userDetailId;

    @NotNull
    private String name;

    @NotNull
    private String surName;

    @NotNull
    @Column(unique = true)
    @Pattern(regexp = Regex.EMAILID, message = "Enter Valid Email ID")
    private String emailId;

    @NotNull
    @Pattern(regexp = Regex.MOBILENO,message = "Enter Valid Mobile Number.")
    private String mobileNo;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd",lenient = OptBoolean.FALSE)
    private Date dateOfBirth;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd" , lenient = OptBoolean.FALSE)
    private Date joinDate;

    @NotNull
    @Digits(integer = 6, fraction = 0)
    private int pinCode;

    private boolean status = true;

}
