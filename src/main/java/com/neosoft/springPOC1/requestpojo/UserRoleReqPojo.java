package com.neosoft.springPOC1.requestpojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleReqPojo {
    private String role;
    private int roleExperience;
}
