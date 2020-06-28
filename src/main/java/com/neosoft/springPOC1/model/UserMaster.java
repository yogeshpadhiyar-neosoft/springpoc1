package com.neosoft.springPOC1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.neosoft.springPOC1.Constant.Regex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @Pattern(regexp = Regex.USERNAME,message = "Enter valid size userName")
    private String userName;

    @NotNull
    @Pattern(regexp = Regex.PASSWORD, message = "invalid password")
    private String password;

    private Boolean active=true;

    @JsonFormat(pattern = "yyyy-MM-dd",lenient = OptBoolean.FALSE)
    private Date createDate;

    @JsonFormat(pattern = "yyyy-MM-dd",lenient = OptBoolean.FALSE)
    private Date updatedDate;

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
