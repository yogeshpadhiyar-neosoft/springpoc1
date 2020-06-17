package com.neosoft.springPOC1.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.neosoft.springPOC1.model.UserDetail;
import com.neosoft.springPOC1.repository.UserDetailRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ServicesTest {
    @Mock
    UserDetailRepository userDetailRepository;

    @InjectMocks
    UserServiceImpl userServiceImplMock;

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
    public void insertTest(){
        doReturn(yogi).when(userDetailRepository).save(any());
        UserDetail expected = yogi;
        UserDetail actual = userServiceImplMock.insert(yogi);
        Assert.assertEquals(expected,actual);
        verify(userDetailRepository).save(any());
    }

    @Test
    public void updateTest(){
        UserDetail yogi1 = new UserDetail(1, "yogi1", "padhiyar", "yogi1@gmail.com",  "7777777777", new Date(1999 , 5, 3), new Date(1999 , 12 , 1), 395006, true);

        doReturn(yogi1).when(userDetailRepository).save(any());
        UserDetail expected = yogi1;
        UserDetail actual = userServiceImplMock.update(yogi1);
        Assert.assertEquals(expected,actual);
        verify(userDetailRepository).save(any());
    }

    @Test
    public void selectByIdTest(){
        when(userDetailRepository.findById(anyInt())).thenReturn(Optional.of(yogi));
        UserDetail expected = yogi;
        UserDetail actual = userServiceImplMock.selectById(1);
        Assert.assertEquals(expected,actual);
        verify(userDetailRepository).findById(anyInt());
    }

    @Test
    public void selectAllTest(){
        List<UserDetail> users = new ArrayList<>();
        users.add(yogi);
        users.add(rahul);
        users.add(dhaval);

        doReturn(users).when(userDetailRepository).findAll();
        List<UserDetail> actualList = userServiceImplMock.selectAll();
        Assert.assertEquals(users,actualList);
        verify(userDetailRepository).findAll();
    }

    @Test
    public void deleteTest(){
        doNothing().doThrow(new IllegalStateException()).when(userDetailRepository).delete(any());
        userServiceImplMock.delete(yogi);
        verify(userDetailRepository).delete(any());
    }

    @Test
    public void dynamicSortTest(){
        List<UserDetail> users = new ArrayList<>();
        users.add(yogi);
        users.add(rahul);
        users.add(dhaval);
        users.sort(Comparator.comparing(UserDetail::getName));

        doReturn(users).when(userDetailRepository).findAll(any(Sort.class));
        List<UserDetail> actualList = userServiceImplMock.dynamicSort("name");
        Assert.assertEquals(users,actualList);
        verify(userDetailRepository).findAll(Sort.by("name").ascending());
    }
}
