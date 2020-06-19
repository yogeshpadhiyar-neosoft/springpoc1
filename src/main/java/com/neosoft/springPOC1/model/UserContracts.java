package com.neosoft.springPOC1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserContracts {

    @ManyToOne
    @JsonBackReference
    private UserMaster userMaster;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;
    private String projectName;
    private String projectDetails;
    private String companyName;
    private Date startDate;
    private Date endDate;
    private boolean activeProject;
}
