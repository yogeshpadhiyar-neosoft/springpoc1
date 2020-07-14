package com.neosoft.springPOC1.requestpojo;

import lombok.Data;

@Data
public class ChangePassword {
    private String oldPassword;
    private String newPassword;
}
