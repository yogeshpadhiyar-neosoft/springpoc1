package com.neosoft.springPOC1.responsepojo;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserContractsPojo {
    private String projectName;
    private String projectDetails;
    private String companyName;
    private Date startDate;
    private Date endDate;
    private boolean activeProject;

}
