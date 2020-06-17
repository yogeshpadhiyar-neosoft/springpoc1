package com.neosoft.springPOC1.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class UserDetailModelTest {

    @Mock
    UserDetail userMock;

    UserDetail yogi;
    UserDetail rahul;
    UserDetail dhaval;

    @Before
    public void setup(){
        yogi = new UserDetail(1, "yogi", "padhiyar", "yogi1@gmail.com",  "7777777777", new Date(1999 , 5, 3), new Date(1999 , 12 , 1), 395006, true);
        rahul = new UserDetail(3, "rahul", "padhiyar", "rahul24@gmail.ac.in", "8888888888", new Date(1996 , 6 , 10), new Date(2000 , 2 , 1), 395006, true);
        dhaval = new UserDetail(4, "dhaval", "padhiyar", "dhaval24@gmail.ac.in", "9999999999", new Date(1996 , 6 , 10), new Date(2000 , 2 , 1), 395006, true);

    }

    @Test
    public void idTest(){
        when(userMock.getId()).thenReturn(1);
        assertEquals(1, yogi.getId());
        yogi.setId(2);
        assertEquals(2, yogi.getId());
    }

    @Test
    public void nameTest(){
        when(userMock.getName()).thenReturn("yogi");
        assertEquals("yogi", yogi.getName());
        yogi.setName("yogesh");
        assertEquals("yogesh", yogi.getName());
    }

    @Test
    public void surNameTest(){
        when(userMock.getSurName()).thenReturn("padhiyar");
        assertEquals("padhiyar", yogi.getSurName());
        yogi.setSurName("padhu");
        assertEquals("padhu", yogi.getSurName());
    }
    @Test
    public void emailIdTest(){
        when(userMock.getEmailID()).thenReturn("yogi1@gmail.com");
        assertEquals("yogi1@gmail.com", yogi.getEmailID());
        yogi.setEmailID("yogi123@gmail.com");
        assertEquals("yogi123@gmail.com", yogi.getEmailID());
    }

    @Test
    public void mobileNoTest(){
        when(userMock.getMobileNo()).thenReturn("7777777777");
        assertEquals("7777777777", yogi.getMobileNo());
        yogi.setMobileNo("8888888888");
        assertEquals("8888888888", yogi.getMobileNo());
    }

    @Test
    public void dobTest(){
        when(userMock.getDOB()).thenReturn(new Date(1999 , 5, 3));
        assertEquals(new Date(1999, 5, 3), yogi.getDOB());
        yogi.setDOB(new Date(2001, 5, 3));
        assertEquals(new Date(2001, 5, 3), yogi.getDOB());
    }

    @Test
    public void joinDateTest(){
        when(userMock.getJoinDate()).thenReturn(new Date(1999 , 12 , 1));
        assertEquals(new Date(1999, 12, 1), yogi.getJoinDate());
        yogi.setJoinDate(new Date(2000, 12, 1));
        assertEquals(new Date(2000, 12, 1), yogi.getJoinDate());
    }

    @Test
    public void pinCodeTest(){
        when(userMock.getPinCode()).thenReturn(395006);
        assertEquals(395006, yogi.getPinCode());
        yogi.setPinCode(395001);
        assertEquals(395001, yogi.getPinCode());
    }

    @Test
    public void statusTest(){
        when(userMock.isStatus()).thenReturn(true);
        assertTrue(yogi.isStatus());
        yogi.setStatus(false);
        assertFalse(yogi.isStatus());
    }
}
