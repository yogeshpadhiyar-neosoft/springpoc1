package com.neosoft.springPOC1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Pattern(regexp = "^[a-zA-Z0-9]{5,15}$",message = "Enter valid size userName")
    private String userName;
//    @Pattern(regexp = "^(?=.?[A-Z])(?=.?[a-z])(?=.?[0-9])(?=.?[#?!@$%^&*-]).{8,}$",message = "invalid password")
    private String password;
    private Boolean active=true;
    private Date createDate;
    private Date UpdatedDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private UserDetail userDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private UserEducation userEducation;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private UserEmployeementDetails userEmployeementDetails;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<UserContracts> userContracts;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private UserRole userRole;
}
