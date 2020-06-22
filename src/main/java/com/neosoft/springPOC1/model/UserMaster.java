package com.neosoft.springPOC1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    @Pattern(regexp = "^[a-zA-Z0-9]{5,15}$",message = "Enter valid size userName")
    private String userName;

    @NotNull
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[&@#$%]).{8,20})", message = "invalid password")
    private String password;

    private Boolean active=true;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
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
