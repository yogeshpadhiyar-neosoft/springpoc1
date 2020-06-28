package com.neosoft.springPOC1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

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

    @NotNull
    private String sscBoardName;

    @NotNull
    private String hscBoardName;

    @NotNull
    private String universityName;

    @NotNull
    @Digits(integer = 2,fraction = 2)
    @Max(value = 100 , message = "Percentage Not more then 100")
    private float sscPercentage;

    @NotNull
    @Digits(integer = 2,fraction = 2)
    @Max(value = 100 , message = "Percentage Not more then 100")

    private float hscPercentage;

    @NotNull
    @Digits(integer = 2,fraction = 2)
    @Max(value = 100 , message = "Percentage Not more then 100")
    private float universityPercentage;

    @NotNull
    @JsonFormat(pattern = "yyyy")
    private int sscPassingYear;

    @NotNull
    @JsonFormat(pattern = "yyyy")
    private int hscPassingYear;

    @NotNull
    @JsonFormat(pattern = "yyyy")
    private int uniPassingYear;

}
