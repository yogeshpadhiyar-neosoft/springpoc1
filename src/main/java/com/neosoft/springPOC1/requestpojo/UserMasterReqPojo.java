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

    private UserDetailReqPojo userDetailReqPojo;
    private UserEducationReqPojo userEducationReqPojo;
    private UserEmployeementDetailsReqPojo userEmployeementDetailsReqPojo;
    private List<UserContractsReqPojo> userContractsReqPojoList;
    private UserRoleReqPojo userRoleReqPojo;
}
