package com.neosoft.springPOC1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    @OneToOne
    @JsonBackReference
    private UserMaster userMaster;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;
    private String role;
    private int roleExperience;

}
