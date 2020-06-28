package com.neosoft.springPOC1.controller;

import com.google.gson.Gson;
import com.neosoft.springPOC1.Constant.Regex;
import com.neosoft.springPOC1.exception.CustomMessage;
import com.neosoft.springPOC1.factorymethod.FactoryPatten;
import com.neosoft.springPOC1.model.UserMaster;
import com.neosoft.springPOC1.requestpojo.UserMasterReqPojo;
import com.neosoft.springPOC1.responsepojo.UserMasterPojo;
import com.neosoft.springPOC1.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Controller
public abstract class ValidationController {

    private final UserDetailService userDetailService;

    @Autowired
    public ValidationController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    /**
     * Check All types of Validation from request entity
     * @param userMasterReqPojo
     * @return boolean
     */
    public boolean valid(UserMasterReqPojo userMasterReqPojo){
        CustomMessage customMessage = new CustomMessage();
        List<String> errors = new ArrayList<>();
        if(!userNameValidator(userMasterReqPojo.getUserName())){
            errors.add("UserName Not Valid");
        }
        if(!passwordValidator(userMasterReqPojo.getPassword())){
            errors.add("Password Not Valid");
        }
        if(!emailIdValidator(userMasterReqPojo.getUserDetailReqPojo().getEmailId())){
            errors.add("Please Enter Valid EmailId.");
        }
        if(!mobileNoValidator(userMasterReqPojo.getUserDetailReqPojo().getMobileNo())){
            errors.add("Mobile Number Not Valid");
        }
        if(!pinCodeValidator(userMasterReqPojo.getUserDetailReqPojo().getPinCode())){
            errors.add("PinCode Not Valid");
        }
        if(!percentageValidator(userMasterReqPojo.getUserEducationReqPojo().getSscPercentage())){
            errors.add("S.S.C percentage Not Valid");
        }
        if(!percentageValidator(userMasterReqPojo.getUserEducationReqPojo().getHscPercentage())){
            errors.add("H.S.C percentage Not Valid");
        }
        if(!percentageValidator(userMasterReqPojo.getUserEducationReqPojo().getUniversityPercentage())){
            errors.add("University percentage Not Valid");
        }
        if(!yearValidator(userMasterReqPojo.getUserEducationReqPojo().getSscPassingYear())){
            errors.add("S.S.C passing Not Valid");
        }
        if(!yearValidator(userMasterReqPojo.getUserEducationReqPojo().getHscPassingYear())){
            errors.add("H.S.C passing Not Valid");
        }
        if(!yearValidator(userMasterReqPojo.getUserEducationReqPojo().getUniPassingYear())){
            errors.add("University passing Not Valid");
        }
        if(!workEmailIdValidator(userMasterReqPojo.getUserEmployeementDetailsReqPojo().getWorkEmailId())){
            errors.add("Work Email Id not valid");
        }
        if(!mobileNoValidator(userMasterReqPojo.getUserEmployeementDetailsReqPojo().getWorkMobileNo())){
            errors.add("Work Mobile Number not valid");
        }
        userMasterReqPojo.getUserContractsReqPojoList().forEach(userContracts ->
            {
                if(!startDateAndEndDateValidator(userContracts.getStartDate(),userContracts.getEndDate())){
                    errors.add("Project name : '"+userContracts.getProjectName()+"' startDate and EndDate Not valid");
                }
            });

        if(errors.isEmpty()){
            return true;
        }
        else{
            customMessage.setHttpStatus(HttpStatus.BAD_REQUEST);
            customMessage.setErrorMessage("Input Json Not Valid");
            customMessage.setErrors(errors);
            throw customMessage;
        }
    }


    /**
     * Here All the method are use of validation check
     */
    public boolean userNameValidator(String userName){
        Pattern userNamePattern = Pattern.compile(Regex.USERNAME);
        return userNamePattern.matcher(userName).matches();
    }

    public boolean passwordValidator(String password){
        Pattern pattern = Pattern.compile(Regex.PASSWORD);
        return pattern.matcher(password).matches();
    }

    public boolean emailIdValidator(String emailId){
        Pattern pattern = Pattern.compile(Regex.EMAILID);
        return (pattern.matcher(emailId).matches() & !userDetailService.emailIdExist(emailId));

    }

    public boolean mobileNoValidator(String mobileNo){
        Pattern pattern = Pattern.compile(Regex.MOBILENO);
        return pattern.matcher(mobileNo).matches();
    }

    public boolean startDateAndEndDateValidator(Date startDate , Date endDate){
        return startDate.compareTo(endDate)<0;
    }

    public boolean pinCodeValidator(int pinCode){
        Pattern pattern = Pattern.compile(Regex.PINCODE);
        return pattern.matcher(String.valueOf(pinCode)).matches();
    }

    public boolean percentageValidator(float percentage){
        Pattern pattern = Pattern.compile(Regex.PERCENTAGE);
        return (pattern.matcher(String.valueOf(percentage)).matches()&(100>percentage));
    }

    public boolean yearValidator(int year){
        Pattern pattern = Pattern.compile(Regex.YEAR);
        return pattern.matcher(String.valueOf(year)).matches();
    }

    public boolean workEmailIdValidator(String workEmailId){
        Pattern pattern = Pattern.compile(Regex.EMAILID);
        return pattern.matcher(workEmailId).matches();
    }


    /**
     * for generic response of Entity
     * @param userMaster
     * @return
     * @throws CustomMessage
     */
    protected ResponseEntity<Object> responseBuilder(UserMaster userMaster ) throws CustomMessage{
        UserMasterPojo userMasterPojo = FactoryPatten.userResponse(userMaster);
        return new ResponseEntity<>(userMasterPojo , HttpStatus.ACCEPTED);
    }


    /**
     * for generic response of List Entity
     * @param userMasterList
     * @return
     * @throws CustomMessage
     */
    protected ResponseEntity<Object> responseBuilder(List<UserMaster> userMasterList ) throws CustomMessage{
        List<UserMasterPojo> userMasterPojoList = new ArrayList<>();
                userMasterList.forEach(userMaster -> {
                    userMasterPojoList.add(FactoryPatten.userResponse(userMaster));
                });
        return new ResponseEntity<>(userMasterPojoList , HttpStatus.ACCEPTED);
    }


    /**
     * Only for return Custom message
     * @param message
     * @return
     */
    protected ResponseEntity<Object> responseMessage(String message) {
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }


    /**
     * Response Custom error as generic response
     * @param ex
     * @return
     */
    protected ResponseEntity<Object> responseEx(CustomMessage ex) {
        return new ResponseEntity<>(new Gson().toJson(ex), HttpStatus.BAD_REQUEST);
    }
}
