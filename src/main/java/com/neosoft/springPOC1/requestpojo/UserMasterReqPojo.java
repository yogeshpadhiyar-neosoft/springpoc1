package com.neosoft.springPOC1.requestpojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserMasterReqPojo {

    private String userName;
    private String password;

    private UserDetailReqPojo userDetailsPojo;
    private UserEducationReqPojo userEducationPojo;
    private UserEmployeementDetailsReqPojo userEmployeementDetailsPojo;
    private List<UserContractsReqPojo> userContractsPojoList;
    private UserRoleReqPojo userRolePojo;
}
