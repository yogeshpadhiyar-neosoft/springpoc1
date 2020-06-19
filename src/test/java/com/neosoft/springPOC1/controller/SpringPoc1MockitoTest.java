/*
package com.neosoft.springPOC1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neosoft.springPOC1.model.UserDetail;
import com.neosoft.springPOC1.model.UserMaster;
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
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
public class SpringPoc1MockitoTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserServiceImpl userServiceImpl;

    @Autowired
    ObjectMapper objectMapper;

    UserDetail yogi;
    UserDetail rahul;
    UserDetail dhaval;
    String yogiString;
    String rahulString;
    String reqURL = "/poc1/userDetail";

    @Before
    public void setup() throws JsonProcessingException {
        UserMaster userMaster = new UserMaster(1,"yogi123","Yogi@123",true,new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()));
        yogi = new UserDetail(userMaster,1L, "yogi", "padhiyar", "yogi1@gmail.com",  "7777777777", new Date(1999 , 5, 3), new Date(1999 , 12 , 1), 395006, true);
        rahul = new UserDetail(userMaster,3L, "rahul", "padhiyar", "rahul24@gmail.ac.in", "8888888888", new Date(1996 , 6 , 10), new Date(2000 , 2 , 1), 395006, true);
        dhaval = new UserDetail(userMaster,4L, "dhaval", "padhiyar", "dhaval24@gmail.ac.in", "9999999999", new Date(1996 , 6 , 10), new Date(2000 , 2 , 1), 395006, true);
        yogiString = objectMapper.writeValueAsString(yogi);
        rahulString = objectMapper.writeValueAsString(rahul);

    }

    @Test
    public void allUserTest() throws Exception {
        List<UserDetail> users = new ArrayList<>();
        users.add(yogi);
        users.add(rahul);

        //given
        Mockito.when(userServiceImpl.selectAll()).thenReturn(users);

        String response = objectMapper.writeValueAsString(users);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get(reqURL + "/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().json(response))
                .andExpect(MockMvcResultMatchers.status().isOk());

        //then
        Mockito.verify(userServiceImpl).selectAll();
    }

    @Test
    public void insertUserTest() throws Exception {

        Mockito.when(userServiceImpl.insert(Mockito.any(UserDetail.class))).thenReturn(dhaval);

        mockMvc.perform(MockMvcRequestBuilders.post(reqURL+"/add")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(dhaval))
                .characterEncoding("UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());


        Mockito.verify(userServiceImpl).insert(Mockito.any());

    }

    @Test
    public void updateUserTest() throws Exception{
        UserMaster userMaster = new UserMaster(1,"yogi123","Yogi@123",true,new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()));
        UserDetail yogi1 = new UserDetail(userMaster,1L, "yogi1", "padhiyar", "yogi522@gmail.com",  "7777777778", new Date(1999 , 5, 3), new Date(1999 , 12 , 1), 395006, true);

        Mockito.when(userServiceImpl.update(Mockito.any(UserDetail.class))).thenReturn(yogi1);

        mockMvc.perform(MockMvcRequestBuilders.put(reqURL+"/1")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(yogi1))
                .characterEncoding("UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());


        Mockito.verify(userServiceImpl).update(Mockito.any());
    }

    @Test
    public void softDeleteTest() throws Exception{
        yogi.setStatus(false);

        Mockito.doNothing().when(userServiceImpl).delete(Mockito.any(UserDetail.class));
        Mockito.when(userServiceImpl.selectById(Mockito.anyInt())).thenReturn(yogi);

        mockMvc.perform(MockMvcRequestBuilders.delete(reqURL+"/softDelete/1")
                .characterEncoding("UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(userServiceImpl).selectById(Mockito.anyInt());
        Mockito.verify(userServiceImpl).update(Mockito.any(UserDetail.class));
    }

    @Test
    public void hardDeleteTest() throws Exception{
        Mockito.when(userServiceImpl.selectById(Mockito.anyInt())).thenReturn(yogi);
        Mockito.doNothing().when(userServiceImpl).delete(Mockito.any(UserDetail.class));

        mockMvc.perform(MockMvcRequestBuilders.delete(reqURL+"/hardDelete/1")
                .characterEncoding("UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(userServiceImpl).selectById(Mockito.anyInt());
        Mockito.verify(userServiceImpl).delete(Mockito.any(UserDetail.class));
    }


    //Here using only Name filed. We can do same as all filed.
    @Test
    public void sortByNameTest() throws Exception{
        List<UserDetail> sortedList = new ArrayList<>();
        sortedList.add(yogi);
        sortedList.add(rahul);
        sortedList.add(dhaval);
        sortedList.sort((o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        });


        Mockito.when(userServiceImpl.dynamicSort(Mockito.anyString())).thenReturn(sortedList);

        mockMvc.perform(MockMvcRequestBuilders.get(reqURL+"/sortByname")
                .characterEncoding("UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(userServiceImpl).dynamicSort(Mockito.anyString());

    }


    //Here using only pinCode filed. We can do same as all filed.
    @Test
    public void dynamicSearchByPinCodeTest() throws Exception{
        List<UserDetail> samePinCodeUser = new ArrayList<>();
        samePinCodeUser.add(yogi);
        samePinCodeUser.add(rahul);
        samePinCodeUser.add(dhaval);

        Mockito.when(userServiceImpl.selectAll()).thenReturn(samePinCodeUser);

        mockMvc.perform(MockMvcRequestBuilders.get(reqURL+"/pincode")
                .characterEncoding("UTF-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(userServiceImpl).selectAll();
    }
}
*/
