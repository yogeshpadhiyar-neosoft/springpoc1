package com.neosoft.springPOC1.factorymethod;

import com.neosoft.springPOC1.model.*;
import com.neosoft.springPOC1.requestpojo.UserContractsReqPojo;
import com.neosoft.springPOC1.requestpojo.UserMasterReqPojo;
import com.neosoft.springPOC1.responsepojo.*;
import org.springframework.stereotype.Component;

import java.sql.Date;
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
        FactoryPatten.userDetailAttribute.add("dateOfBirth");
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
    public static String selectQueryConstructor(String url){
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


    /**
     * Convert userMaster Model into UserMasterPojo
     * for UI specific response
     * @param userMaster
     * @return UserMasterPojo
     */
    public static UserMasterPojo userResponse(UserMaster userMaster){

        UserDetailsPojo userDetailsPojo = new UserDetailsPojo(userMaster.getUserDetail().getName(),userMaster.getUserDetail().getSurName(),
                userMaster.getUserDetail().getEmailId(),userMaster.getUserDetail().getMobileNo(),userMaster.getUserDetail().getDateOfBirth(),
                userMaster.getUserDetail().getJoinDate(),userMaster.getUserDetail().getPinCode());

        UserEducationPojo userEducationPojo = new UserEducationPojo(userMaster.getUserEducation().getSscBoardName(),userMaster.getUserEducation().getHscBoardName()
                ,userMaster.getUserEducation().getUniversityName(),userMaster.getUserEducation().getSscPercentage(),userMaster.getUserEducation().getHscPercentage()
                ,userMaster.getUserEducation().getUniversityPercentage(),userMaster.getUserEducation().getSscPassingYear(),userMaster.getUserEducation().getHscPassingYear()
                ,userMaster.getUserEducation().getUniPassingYear());

        UserEmployeementDetailsPojo userEmployeementDetailsPojo = new UserEmployeementDetailsPojo(userMaster.getUserEmployeementDetails().getDepartment(),userMaster.getUserEmployeementDetails().getWorkEmailId(),
                userMaster.getUserEmployeementDetails().getWorkMobileNo(),userMaster.getUserEmployeementDetails().getSalary(),userMaster.getUserEmployeementDetails().getEmployeeJoinDate(),userMaster.getUserEmployeementDetails().getExperience());

        List<UserContractsPojo> userContractsPojoList = new ArrayList<UserContractsPojo>();
        userMaster.getUserContracts().forEach(project->{
            userContractsPojoList.add(new UserContractsPojo(project.getProjectName(),project.getProjectDetails(),project.getCompanyName(),project.getStartDate(),project.getEndDate(),project.isActiveProject()));
        });

        UserRolePojo userRolePojo = new UserRolePojo(userMaster.getUserRole().getRole(),userMaster.getUserRole().getRoleExperience());

        return new UserMasterPojo(userMaster.getUserId(),userMaster.getUserName(),userDetailsPojo,userEducationPojo,userEmployeementDetailsPojo,userContractsPojoList,userRolePojo);

    }

    /**
     * Convert user request json into UserMaster Model
     * this request Accept only valid json
     * so first need to check that UserMasterReqPojo is valid or not
     * @param userMasterReqPojo
     * @return UserMaster
     */
    public static UserMaster userRequest(UserMasterReqPojo userMasterReqPojo){

        UserDetail userDetail = new UserDetail();
        userDetail.setName(userMasterReqPojo.getUserDetailsPojo().getName());
        userDetail.setSurName(userMasterReqPojo.getUserDetailsPojo().getSurName());
        userDetail.setEmailId(userMasterReqPojo.getUserDetailsPojo().getEmailId());
        userDetail.setMobileNo(userMasterReqPojo.getUserDetailsPojo().getMobileNo());
        userDetail.setDateOfBirth(userMasterReqPojo.getUserDetailsPojo().getDateOfBirth());
        userDetail.setJoinDate(userMasterReqPojo.getUserDetailsPojo().getJoinDate());
        userDetail.setPinCode(userMasterReqPojo.getUserDetailsPojo().getPinCode());
        userDetail.setStatus(true);

        UserEducation userEducation = new UserEducation();
        userEducation.setSscBoardName(userMasterReqPojo.getUserEducationPojo().getSscBoardName());
        userEducation.setHscBoardName(userMasterReqPojo.getUserEducationPojo().getHscBoardName());
        userEducation.setUniversityName(userMasterReqPojo.getUserEducationPojo().getUniversityName());
        userEducation.setSscPercentage(userMasterReqPojo.getUserEducationPojo().getSscPercentage());
        userEducation.setHscPercentage(userMasterReqPojo.getUserEducationPojo().getHscPercentage());
        userEducation.setUniversityPercentage(userMasterReqPojo.getUserEducationPojo().getUniversityPercentage());
        userEducation.setSscPassingYear(userMasterReqPojo.getUserEducationPojo().getSscPassingYear());
        userEducation.setHscPassingYear(userMasterReqPojo.getUserEducationPojo().getHscPassingYear());
        userEducation.setUniPassingYear(userMasterReqPojo.getUserEducationPojo().getUniPassingYear());


        UserEmployeementDetails userEmployeementDetails = new UserEmployeementDetails();
        userEmployeementDetails.setDepartment(userMasterReqPojo.getUserEmployeementDetailsPojo().getDepartment());
        userEmployeementDetails.setWorkMobileNo(userMasterReqPojo.getUserEmployeementDetailsPojo().getWorkMobileNo());
        userEmployeementDetails.setWorkEmailId(userMasterReqPojo.getUserEmployeementDetailsPojo().getWorkEmailId());
        userEmployeementDetails.setSalary(userMasterReqPojo.getUserEmployeementDetailsPojo().getSalary());
        userEmployeementDetails.setEmployeeJoinDate(userMasterReqPojo.getUserEmployeementDetailsPojo().getEmployeeJoinDate());
        userEmployeementDetails.setExperience(userMasterReqPojo.getUserEmployeementDetailsPojo().getExperience());


        List<UserContracts> userContractsList = new ArrayList<>();
        for (UserContractsReqPojo project : userMasterReqPojo.getUserContractsPojoList()) {
            UserContracts userContracts = new UserContracts();
            userContracts.setProjectName(project.getProjectName());
            userContracts.setProjectDetails(project.getProjectDetails());
            userContracts.setCompanyName(project.getCompanyName());
            userContracts.setStartDate(project.getStartDate());
            userContracts.setEndDate(project.getEndDate());
            userContracts.setActiveProject(project.isActiveProject());
            userContractsList.add(userContracts);
        }

        UserRole userRole = new UserRole();
        userRole.setRole(userMasterReqPojo.getUserRolePojo().getRole());
        userRole.setRoleExperience(userMasterReqPojo.getUserRolePojo().getRoleExperience());

        UserMaster userMaster = new UserMaster();
        userMaster.setUserName(userMasterReqPojo.getUserName());
        userMaster.setPassword(userMasterReqPojo.getPassword());
        userMaster.setActive(true);
        userMaster.setCreateDate(new Date(new java.util.Date().getTime()));
        userMaster.setUpdatedDate(new Date(new java.util.Date().getTime()));
        userMaster.setUserDetail(userDetail);
        userMaster.setUserEducation(userEducation);
        userMaster.setUserEmployeementDetails(userEmployeementDetails);
        userMaster.setUserContracts(userContractsList);
        userMaster.setUserRole(userRole);
        return userMaster;
    }
}
