package com.neosoft.springPOC1.factoryMethod;

import com.neosoft.springPOC1.model.UserDetail;

import java.util.ArrayList;
import java.util.List;

public class FactoryPatten {
    public static List<String> userStringList(UserDetail userDetail){
        List<String> stringList = new ArrayList<>();
        stringList.add(String.valueOf(userDetail.getId()));
        stringList.add(userDetail.getName());
        stringList.add(userDetail.getSurName());
        stringList.add(userDetail.getEmailID());
        stringList.add(String.valueOf(userDetail.getMobileNo()));
        stringList.add(String.valueOf(userDetail.getDOB()));
        stringList.add(String.valueOf(userDetail.getJoinDate()));
        stringList.add(String.valueOf(userDetail.getPinCode()));
        return stringList;
    }
}
