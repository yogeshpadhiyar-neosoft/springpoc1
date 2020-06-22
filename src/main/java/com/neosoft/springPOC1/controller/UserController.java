package com.neosoft.springPOC1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neosoft.springPOC1.Constant.ErrorMessages;
import com.neosoft.springPOC1.exception.UserException;
import com.neosoft.springPOC1.factorymethod.FactoryPatten;
import com.neosoft.springPOC1.model.*;
import com.neosoft.springPOC1.service.DynamicSearchCustomImpl;
import com.neosoft.springPOC1.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/poc1/userDetail")
public class UserController {

    private final UserServiceImpl userServiceImpl;
    private final DynamicSearchCustomImpl dynamicSearch;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl , DynamicSearchCustomImpl dynamicSearch) {
        this.userServiceImpl = userServiceImpl;
        this.dynamicSearch = dynamicSearch;
    }

    /**
     * User for all user database
     * No need any input for display all user data
     * DashBoard
     * @return
     */
    @GetMapping("/")
    public List<UserMaster> allUser(){
        List<UserMaster> userMasterList = userServiceImpl.selectAll();
            if(userMasterList.isEmpty())
                throw new UserException(ErrorMessages.ANY_USER_NOT_FOUND);
            else
                return userMasterList;

    }


    /**
     * New Registration of User
     * Insert new user need to all table data.
     * @param userMaster
     * @return inserted data
     */
    @PostMapping(value = "/add", consumes = "application/json")
    public UserMaster insertUser(@Valid @RequestBody UserMaster userMaster) {
        return userServiceImpl.insertMaster(userMaster);
    }


    /**
     * use for update user details
     * @param id
     * @param userMaster
     * @return updated data
     */
    @PutMapping("/{userId}")
    public UserMaster updateUser(@PathVariable("userId") long id, @RequestBody UserMaster userMaster) {
        if(userServiceImpl.selectById(id)==null){
            throw new UserException(ErrorMessages.NO_USER_FOUND);
        }
        return userServiceImpl.updateMaster(userMaster,id);
    }


    /**
     * soft delete mean only set user in active
     * status false
     * @param id
     * @param userMaster
     */
    @DeleteMapping("/softDelete/{userId}")
    public void softDelete(@PathVariable("userId") long id, @ModelAttribute UserMaster userMaster) {
        userMaster = userServiceImpl.selectById(id);
        if(userMaster==null){
            throw new UserException(ErrorMessages.NO_USER_FOUND);
        }
        userMaster.setActive(false);
        userMaster.getUserDetail().setStatus(false);
        userServiceImpl.updateMaster(userMaster,id);
    }

    /**
     * hard delete means also delete from database
     * @param id
     * @param userMaster
     */
    @DeleteMapping("/hardDelete/{userId}")
    public void hardDelete(@PathVariable("userId") long id, @ModelAttribute UserMaster userMaster) {
        userMaster = userServiceImpl.selectById(id);
        if(userMaster==null){
            throw new UserException(ErrorMessages.NO_USER_FOUND);
        }
        userServiceImpl.delete(userMaster);
    }


    /**
     * this method is use for dynamic search
     * need to insert parameter and values
     * like "fieldName1=value1&fieldName2=value2"
     * @param query
     * @return searched user list
     */
    @GetMapping("/{query}")
    public List<UserMaster> dynamicSearch(@PathVariable("query") String query) {
        query= FactoryPatten.queryConstructor(query);
        System.out.println(query);
        return dynamicSearch.dynamicSearch(query);
    }


    /**
     * Method is use for dynamic sorting with anny of filed in database
     * URL passing like "ModelName.filedName"
     * @param field
     * @return
     */
    @GetMapping("/sortBy{field}")
    public List<UserMaster> sortBy(@PathVariable("field") String field) {
        return userServiceImpl.dynamicSort(field);
    }


    /**
     * Use for generate Json file using Postman
     * once Json generate remove UserId from all other entity
     * also remove all entity ID
     * @return Generated Json
     * @throws JsonProcessingException
     */
    /*@GetMapping("/jsonGenerate")
    public String jsonGenerator() throws JsonProcessingException {
        UserMaster userMaster = null;
        UserDetail userDetail = new UserDetail(userMaster,1L, "yogi", "padhiyar", "yogi1@gmail.com",  "7777777777", Date.valueOf("1999-05-20"), Date.valueOf("1999-10-07"), 395006, true);
        UserEducation userEducation = new UserEducation(userMaster,1L,"Gujarat","Gujarat","GTU",80.43f,82.67f,85.65f,2014,2016,2020);
        UserEmployeementDetails userEmployeementDetails = new UserEmployeementDetails(userMaster,1L,"CE","gfsds2@dsf.com","7777777777",654322,Date.valueOf("2020-01-07"),2);
        UserContracts userContracts = new UserContracts(userMaster,1L,"Vacation Decation","defination","Boby",Date.valueOf("2018-02-20"),Date.valueOf("2019-03-21"),true);
        UserContracts userContracts1 = new UserContracts(userMaster,2L,"SHSAD","details","yogi",Date.valueOf("2019-04-01"),Date.valueOf("2020-02-01"),true);

        List<UserContracts> userContractsLs = new ArrayList<>();
        userContractsLs.add(userContracts);
        userContractsLs.add(userContracts1);

        UserRole userRole = new UserRole(userMaster,1L,"Dev",2);
        UserMaster userMaster1 = new UserMaster(1L,"yogi123","Yogi@123",true,Date.valueOf("2019-12-01"),Date.valueOf("2020-06-19"),userDetail,userEducation,userEmployeementDetails,userContractsLs,userRole);


        UserDetail userDetail2 = new UserDetail(userMaster,2L, "rahul", "padhiyar", "rahul1@gmail.com",  "7777777788", Date.valueOf("1996-05-20"), Date.valueOf("1998-10-07"), 395006, true);
        UserEducation userEducation2 = new UserEducation(userMaster,2L,"Gujarat","Gujarat","GTU",80.43f,82.67f,85.65f,2014,2016,2020);
        UserEmployeementDetails userEmployeementDetails2 = new UserEmployeementDetails(userMaster,2L,"EC","gfsds2@dsf.com","7777777788",654322,Date.valueOf("2020-01-07"),4);
        UserContracts userContracts21 = new UserContracts(userMaster,3L,"Vacation Decation","defination","rahul",Date.valueOf("2018-02-20"),Date.valueOf("2019-03-21"),true);
        UserContracts userContracts22 = new UserContracts(userMaster,4L,"SHSAD","details","yogi",Date.valueOf("2019-04-01"),Date.valueOf("2020-02-01"),true);

        List<UserContracts> userContractsLs2 = new ArrayList<>();
        userContractsLs2.add(userContracts21);
        userContractsLs2.add(userContracts22);

        UserRole userRole2 = new UserRole(userMaster,2L,"Dev",4);
        UserMaster userMaster2 = new UserMaster(2L,"rahul123","Rahul@123",true,Date.valueOf("2019-12-01"),Date.valueOf("2020-06-19"),userDetail2,userEducation2,userEmployeementDetails2,userContractsLs2,userRole2);

        List<UserMaster> userMasterList = new ArrayList<>();
        userMasterList.add(userMaster1);
        userMasterList.add(userMaster2);
        return new ObjectMapper().writeValueAsString(userMasterList);
    }*/
}



