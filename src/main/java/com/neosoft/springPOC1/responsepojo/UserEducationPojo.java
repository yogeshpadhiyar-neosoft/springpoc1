package com.neosoft.springPOC1.responsepojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEducationPojo {
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
