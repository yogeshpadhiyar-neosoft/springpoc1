package com.neosoft.springPOC1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neosoft.springPOC1.controller.UserController;
import com.neosoft.springPOC1.model.*;
import com.neosoft.springPOC1.service.DynamicSearchCustomImpl;
import com.neosoft.springPOC1.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
public class SpringPoc1MockitoTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserServiceImpl userServiceImpl;
    @MockBean
    DynamicSearchCustomImpl dynamicSearch;

    @Autowired
    ObjectMapper objectMapper;

    UserMaster userMaster1;
    UserMaster userMaster1Updated;
    UserMaster userMaster2;
    String userMaster1String;
    String userMaster1UpdatedString;
    String userMaster2String;
    String reqURL = "/poc1/userDetail";

    @Before
    public void setup() throws JsonProcessingException {
        UserMaster userMaster = null;

        //userMaster 1 details
        UserDetail userDetail1 = new UserDetail(userMaster,1L, "yogi", "padhiyar", "yogi1@gmail.com",  "7777777777", Date.valueOf("1999-05-20"), Date.valueOf("1999-10-07"), 395006, true);
        UserEducation userEducation1 = new UserEducation(userMaster,1L,"Gujarat","Gujarat","GTU",80.43f,82.67f,85.65f,2014,2016,2020);
        UserEmployeementDetails userEmployeementDetails1 = new UserEmployeementDetails(userMaster,1L,"CE","gfsds2@dsf.com","7777777777",654322,Date.valueOf("2020-01-07"),2);
        UserContracts userContracts11 = new UserContracts(userMaster,1L,"Vacation Decation","defination","Boby",Date.valueOf("2018-02-20"),Date.valueOf("2019-03-21"),true);
        UserContracts userContracts12 = new UserContracts(userMaster,2L,"SHSAD","details","yogi",Date.valueOf("2019-04-01"),Date.valueOf("2020-02-01"),true);

        List<UserContracts> userContractsLs1 = new ArrayList<>();
        userContractsLs1.add(userContracts11);
        userContractsLs1.add(userContracts12);

        UserRole userRole1 = new UserRole(userMaster,1L,"Dev",2);
        userMaster1 = new UserMaster(1L,"yogi123","Yogi@123",true,Date.valueOf("2019-12-01"),Date.valueOf("2020-06-19"),userDetail1,userEducation1,userEmployeementDetails1,userContractsLs1,userRole1);
        userMaster1String = objectMapper.writeValueAsString(userMaster1);


        //userMaster 2 details
        UserDetail userDetail2 = new UserDetail(userMaster,2L, "rahul", "padhiyar", "rahul1@gmail.com",  "7777777788", Date.valueOf("1996-05-20"), Date.valueOf("1998-10-07"), 395006, true);
        UserEducation userEducation2 = new UserEducation(userMaster,2L,"Gujarat","Gujarat","GTU",80.43f,82.67f,85.65f,2014,2016,2020);
        UserEmployeementDetails userEmployeementDetails2 = new UserEmployeementDetails(userMaster,2L,"EC","gfsds2@dsf.com","7777777788",654322,Date.valueOf("2020-01-07"),4);
        UserContracts userContracts21 = new UserContracts(userMaster,3L,"Vacation Decation","defination","rahul",Date.valueOf("2018-02-20"),Date.valueOf("2019-03-21"),true);
        UserContracts userContracts22 = new UserContracts(userMaster,4L,"SHSAD","details","yogi",Date.valueOf("2019-04-01"),Date.valueOf("2020-02-01"),true);

        List<UserContracts> userContractsLs2 = new ArrayList<>();
        userContractsLs2.add(userContracts21);
        userContractsLs2.add(userContracts22);

        UserRole userRole2 = new UserRole(userMaster,2L,"Dev",4);
        userMaster2 = new UserMaster(2L,"rahul123","Rahul@123",true,Date.valueOf("2019-12-01"),Date.valueOf("2020-06-19"),userDetail2,userEducation2,userEmployeementDetails2,userContractsLs2,userRole2);
        userMaster2String = objectMapper.writeValueAsString(userMaster2);


    }


    /**
     * positive Testing
     * Testing of searching  all users
     * @throws Exception
     */
    @Test
    public void allUserTest() throws Exception {
        List<UserMaster> users = new ArrayList<>();
        users.add(userMaster1);
        users.add(userMaster2);

        //given
        Mockito.when(userServiceImpl.selectAll()).thenReturn(users);

        String response = objectMapper.writeValueAsString(users);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get(reqURL + "/").characterEncoding("UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().json(response))
                .andExpect(MockMvcResultMatchers.status().isOk());

        //then
        Mockito.verify(userServiceImpl).selectAll();
    }


    /**
     * inserting user testing
     * @throws Exception
     */
    @Test
    public void insertUserTest() throws Exception {

        Mockito.when(userServiceImpl.insertMaster(Mockito.any(UserMaster.class))).thenReturn(userMaster1);

        mockMvc.perform(MockMvcRequestBuilders.post(reqURL+"/add")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(userMaster1String)
                .characterEncoding("UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());


        Mockito.verify(userServiceImpl).insertMaster(Mockito.any());

    }

    /**
     * update user testing
     * @throws Exception
     */
    @Test
    public void updateUserTest() throws Exception{
        UserMaster userMaster = null;
        //userMaster1 Update details
        UserDetail userDetail1 = new UserDetail(userMaster,1L, "yogi", "padhiyar", "yogi1@gmail.com",  "7777777777", Date.valueOf("1999-05-20"), Date.valueOf("1999-10-07"), 395006, true);
        UserEducation userEducation1 = new UserEducation(userMaster,1L,"Gujarat","Gujarat","GTU",80.43f,82.67f,85.65f,2014,2016,2020);
        UserEmployeementDetails userEmployeementDetails1 = new UserEmployeementDetails(userMaster,1L,"CE","gfsds2@dsf.com","7777777777",654322,Date.valueOf("2020-01-07"),2);
        UserContracts userContracts11 = new UserContracts(userMaster,1L,"Vacation Decation","defination","Boby",Date.valueOf("2018-02-20"),Date.valueOf("2019-03-21"),true);
        UserContracts userContracts12 = new UserContracts(userMaster,2L,"SHSAD","details","yogi",Date.valueOf("2019-04-01"),Date.valueOf("2020-02-01"),true);

        List<UserContracts> userContractsLs1 = new ArrayList<>();
        userContractsLs1.add(userContracts11);
        userContractsLs1.add(userContracts12);

        UserRole userRole1 = new UserRole(userMaster,1L,"Dev",2);
        userMaster1Updated = new UserMaster(1L,"yogesh123","Yogesh@123",true,Date.valueOf("2019-12-01"),Date.valueOf("2020-06-19"),userDetail1,userEducation1,userEmployeementDetails1,userContractsLs1,userRole1);
        userMaster1UpdatedString = objectMapper.writeValueAsString(userMaster1Updated);

        Mockito.when(userServiceImpl.selectById(Mockito.anyLong())).thenReturn(userMaster1);
        Mockito.when(userServiceImpl.updateMaster(Mockito.any(UserMaster.class), Mockito.anyLong())).thenReturn(userMaster1Updated);

        mockMvc.perform(MockMvcRequestBuilders.put(reqURL+"/1")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(userMaster1UpdatedString)
                .characterEncoding("UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(userServiceImpl).selectById(Mockito.anyLong());
        Mockito.verify(userServiceImpl).updateMaster(Mockito.any(UserMaster.class),Mockito.anyLong());
    }

    /**
     * soft delete testing
     * @throws Exception
     */
    @Test
    public void softDeleteTest() throws Exception{
        userMaster1.setActive(false);
        userMaster1.getUserDetail().setStatus(false);

        Mockito.when(userServiceImpl.selectById(Mockito.anyLong())).thenReturn(userMaster1);
        Mockito.doNothing().when(userServiceImpl).delete(Mockito.any(UserMaster.class));

        mockMvc.perform(MockMvcRequestBuilders.delete(reqURL+"/softDelete/1")
                .characterEncoding("UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(userServiceImpl).selectById(Mockito.anyLong());
        Mockito.verify(userServiceImpl).updateMaster(Mockito.any(UserMaster.class),Mockito.anyLong());
    }

    /**
     * hard delete testing
     * @throws Exception
     */
    @Test
    public void hardDeleteTest() throws Exception{
        Mockito.when(userServiceImpl.selectById(Mockito.anyLong())).thenReturn(userMaster1);
        Mockito.doNothing().when(userServiceImpl).delete(Mockito.any(UserMaster.class));

        mockMvc.perform(MockMvcRequestBuilders.delete(reqURL+"/hardDelete/1")
                .characterEncoding("UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(userServiceImpl).selectById(Mockito.anyLong());
        Mockito.verify(userServiceImpl).delete(Mockito.any());
    }


    /**
     * sorting testing
     * Here using only Name filed. We can do same as all filed.
     * @throws Exception
     */
    @Test
    public void sortByNameTest() throws Exception{
        List<UserMaster> sortedList = new ArrayList<>();
        sortedList.add(userMaster1);
        sortedList.add(userMaster2);
        sortedList.sort(Comparator.comparing(UserMaster::getUserName));


        Mockito.when(userServiceImpl.dynamicSort(Mockito.anyString())).thenReturn(sortedList);

        mockMvc.perform(MockMvcRequestBuilders.get(reqURL+"/sortByuserName")
                .characterEncoding("UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(userServiceImpl).dynamicSort(Mockito.anyString());

    }


    /**
     * dynamic search testing
     * Here using only pinCode filed. We can do same as all filed.
     * @throws Exception
     */
    @Test
    public void dynamicSearchByPinCodeTest() throws Exception{
        List<UserMaster> samePinCodeUser = new ArrayList<>();
        samePinCodeUser.add(userMaster1);
        samePinCodeUser.add(userMaster2);

        String output = objectMapper.writeValueAsString(samePinCodeUser);
        Mockito.when(dynamicSearch.dynamicSearch(Mockito.any())).thenReturn(samePinCodeUser);

        mockMvc.perform(MockMvcRequestBuilders.get(reqURL+"/pinCode=395006")
                .characterEncoding("UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().json(output))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(dynamicSearch).dynamicSearch(Mockito.any());
    }
}
