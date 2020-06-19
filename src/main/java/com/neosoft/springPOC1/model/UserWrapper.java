package com.neosoft.springPOC1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserWrapper {
    private UserMaster userMaster;
    private UserDetail userDetail;
    private UserEducation userEducation;
    private UserEmployeementDetails userEmployeementDetails;
    private UserContracts userContracts;
    private UserRole userRole;
}
