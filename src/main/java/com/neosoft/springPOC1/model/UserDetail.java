package com.neosoft.springPOC1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Pattern(regexp = "^([a-z0-9_\\-\\.]+)@([a-z0-9_\\-\\.]+)\\.([a-z]{2,5})$", message = "Enter Valid Email ID")
    private String emailId;

    @NotNull
    @Pattern(regexp = "^[1-9][0-9]{9}$",message = "Enter Valid Mobile Number.")
    private String mobileNo;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date joinDate;

    @NotNull
    @Digits(integer = 6, fraction = 0)
    private int pinCode;

    private boolean status = true;

}
