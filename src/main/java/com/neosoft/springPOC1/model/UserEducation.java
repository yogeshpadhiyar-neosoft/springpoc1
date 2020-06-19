package com.neosoft.springPOC1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEducation {

    @OneToOne
    @JsonBackReference
    private UserMaster userMaster;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userEducationId;
    private String sscBoardName;
    private String hscBoardName;
    private String universityName;

    @Digits(integer = 2,fraction = 2)
    private float sscPercentage;

    @Digits(integer = 2,fraction = 2)
    private float hscPercentage;

    @Digits(integer = 2,fraction = 2)
    private float universityPercentage;

    @Digits(integer = 4, fraction = 0)
    private int sscPassingYear;

    @Digits(integer = 4, fraction = 0)
    private int hscPassingYear;

    @Digits(integer = 4, fraction = 0)
    private int uniPassingYear;

}
