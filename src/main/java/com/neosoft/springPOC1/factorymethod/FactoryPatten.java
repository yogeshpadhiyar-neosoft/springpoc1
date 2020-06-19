package com.neosoft.springPOC1.factorymethod;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FactoryPatten {

    public static List<String> userMasterAttribute = new ArrayList<>();
    public static List<String> userDetailAttribute = new ArrayList<>();
    public static List<String> userEducationAttribute = new ArrayList<>();
    public static List<String> userEmployeeAttribute = new ArrayList<>();
    public static List<String> userContractsAttribute = new ArrayList<>();
    public static List<String> userRoleAttribute = new ArrayList<>();
    public FactoryPatten() {
        FactoryPatten.userMasterAttribute.add("userId");
        FactoryPatten.userMasterAttribute.add("userName");
        FactoryPatten.userMasterAttribute.add("password");
        FactoryPatten.userMasterAttribute.add("createDate");
        FactoryPatten.userMasterAttribute.add("updateDate");

        FactoryPatten.userDetailAttribute.add("userDetailId");
        FactoryPatten.userDetailAttribute.add("name");
        FactoryPatten.userDetailAttribute.add("surName");
        FactoryPatten.userDetailAttribute.add("emailId");
        FactoryPatten.userDetailAttribute.add("mobileNo");
        FactoryPatten.userDetailAttribute.add("DOB");
        FactoryPatten.userDetailAttribute.add("joinDate");
        FactoryPatten.userDetailAttribute.add("pinCode");

        FactoryPatten.userEducationAttribute.add("userEducationId");
        FactoryPatten.userEducationAttribute.add("sscBoardName");
        FactoryPatten.userEducationAttribute.add("hscBoardName");
        FactoryPatten.userEducationAttribute.add("universityName");
        FactoryPatten.userEducationAttribute.add("sscPercentage");
        FactoryPatten.userEducationAttribute.add("hscPercentage");
        FactoryPatten.userEducationAttribute.add("universityPercentage");
        FactoryPatten.userEducationAttribute.add("sscPassingYear");
        FactoryPatten.userEducationAttribute.add("hscPassingYear");
        FactoryPatten.userEducationAttribute.add("uniPassingYear");

        FactoryPatten.userEmployeeAttribute.add("userEmployeeId");
        FactoryPatten.userEmployeeAttribute.add("department");
        FactoryPatten.userEmployeeAttribute.add("workEmailId");
        FactoryPatten.userEmployeeAttribute.add("workMobileNo");
        FactoryPatten.userEmployeeAttribute.add("salary");
        FactoryPatten.userEmployeeAttribute.add("employeeJoinDate");
        FactoryPatten.userEmployeeAttribute.add("experience");

        FactoryPatten.userContractsAttribute.add("projectId");
        FactoryPatten.userContractsAttribute.add("projectName");
        FactoryPatten.userContractsAttribute.add("projectDetails");
        FactoryPatten.userContractsAttribute.add("companyName");
        FactoryPatten.userContractsAttribute.add("startDate");
        FactoryPatten.userContractsAttribute.add("endDate");
        FactoryPatten.userContractsAttribute.add("activeProject");

        FactoryPatten.userRoleAttribute.add("roleId");
        FactoryPatten.userRoleAttribute.add("role");
        FactoryPatten.userRoleAttribute.add("roleExperience");
    }


    /**
     * this method use for generate query using URL
     * have to pass string like "fieldName1=value1&fieldName2=value2"
     * @param url
     * @return
     */
    public static String queryConstructor(String url){
        StringBuilder query = new StringBuilder("select user from UserMaster user where ");
        String[] paramAndValue = url.split("[=&|]");
        for (int i = 0; i < paramAndValue.length; i+=2) {
            if(userMasterAttribute.contains(paramAndValue[i]))
                query.append("user.").append(paramAndValue[i]+"='"+paramAndValue[i+1]+"'");
            else if(userDetailAttribute.contains(paramAndValue[i]))
                query.append("user.userDetail.").append(paramAndValue[i]+"='"+paramAndValue[i+1]+"'");
            else if(userEducationAttribute.contains(paramAndValue[i]))
                query.append("user.userEducation.").append(paramAndValue[i]+"='"+paramAndValue[i+1]+"'");
            else if(userEmployeeAttribute.contains(paramAndValue[i]))
                query.append("user.userEmployeementDetails.").append(paramAndValue[i]+"='"+paramAndValue[i+1]+"'");
            else if(userContractsAttribute.contains(paramAndValue[i]))
                query.append("user.userContracts.").append(paramAndValue[i]+"='"+paramAndValue[i+1]+"'");
            else if(userRoleAttribute.contains(paramAndValue[i]))
                query.append("user.userRole.").append(paramAndValue[i]+"='"+paramAndValue[i+1]+"'");
            else
                    return null;
            if(i+1!=paramAndValue.length-1)
                query.append(" and ");
        }
        return query.toString();
    }

    /*public static List<String> userStringList(UserDetail userDetail){
        List<String> stringList = new ArrayList<>();
        stringList.add(String.valueOf(userDetail.getUserDetailId()));
        stringList.add(userDetail.getName());
        stringList.add(userDetail.getSurName());
        stringList.add(userDetail.getEmailId());
        stringList.add(String.valueOf(userDetail.getMobileNo()));
        stringList.add(String.valueOf(userDetail.getDOB()));
        stringList.add(String.valueOf(userDetail.getJoinDate()));
        stringList.add(String.valueOf(userDetail.getPinCode()));
        return stringList;
    }*/
}
