package com.neosoft.springPOC1.requestpojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEducationReqPojo {
    private String sscBoardName;
    private String hscBoardName;
    private String universityName;
    private float sscPercentage;
    private float hscPercentage;
    private float universityPercentage;
    private int sscPassingYear;
    private int hscPassingYear;
    private int uniPassingYear;
}
