package com.neosoft.springPOC1.responsepojo;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserMasterPojo {
    /*private long userId;*/
    private String userName;


    private UserDetailsPojo userDetailsPojo;
    private UserEducationPojo userEducationPojo;
    private UserEmployeementDetailsPojo userEmployeementDetailsPojo;
    private List<UserContractsPojo> userContractsPojoList;
    private UserRolePojo userRolePojo;

}
