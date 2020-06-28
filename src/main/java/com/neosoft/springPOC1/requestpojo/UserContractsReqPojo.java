package com.neosoft.springPOC1.requestpojo;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserContractsReqPojo {
    private String projectName;
    private String projectDetails;
    private String companyName;
    private Date startDate;
    private Date endDate;
    private boolean activeProject;
}
