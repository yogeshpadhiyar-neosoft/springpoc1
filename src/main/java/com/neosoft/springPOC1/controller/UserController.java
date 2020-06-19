package com.neosoft.springPOC1.controller;

import com.neosoft.springPOC1.factorymethod.FactoryPatten;
import com.neosoft.springPOC1.model.UserMaster;
import com.neosoft.springPOC1.service.DynamicSearchCustomImpl;
import com.neosoft.springPOC1.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public List<UserMaster> allUser() {
        return userServiceImpl.selectAll();
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


    /*@GetMapping("/wrapper")
    public String addUserFullDetails() throws JsonProcessingException {
        UserMaster userMaster = null;
        UserDetail userDetail = new UserDetail(userMaster,1L, "yogi", "padhiyar", "yogi1@gmail.com",  "7777777777", new Date(1999 , 5, 3), new Date(1999 , 12 , 1), 395006, true);
        UserEducation userEducation = new UserEducation(userMaster,1L,"Gujarat","Gujarat","GTU",80.00f,82.00f,85.65f,2014,2016,2020);
        UserEmployeementDetails userEmployeementDetails = new UserEmployeementDetails(userMaster,1L,"CE","gfsds2@dsf.com","777777777",654322,new Date(System.currentTimeMillis()),2);
        UserContracts userContracts = new UserContracts(userMaster,1L,"SHSAD","hfgsssdggs","dsfdfs",new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),true);
        UserContracts userContracts1 = new UserContracts(userMaster,1L,"SHSAD","hfgsssdggs","dsfdfs",new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),true);

        List<UserContracts> userContractsLs = new ArrayList<>();
        userContractsLs.add(userContracts);
        userContractsLs.add(userContracts1);

        UserRole userRole = new UserRole(userMaster,1L,"Dev",2);
        UserMaster userMaster1 = new UserMaster(1L,"yogi123","Yogi@123",true,new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),userDetail,userEducation,userEmployeementDetails,userContractsLs,userRole);

        return new ObjectMapper().writeValueAsString(userMaster1);
    }*/
}



