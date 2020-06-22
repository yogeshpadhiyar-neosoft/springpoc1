package com.neosoft.springPOC1;

import com.neosoft.springPOC1.model.*;
import com.neosoft.springPOC1.repository.UserMasterRepo;
import com.neosoft.springPOC1.service.DynamicSearchCustomImpl;
import com.neosoft.springPOC1.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ServicesTest {
    @Mock
    UserMasterRepo userMasterRepo;

    @InjectMocks
    UserServiceImpl userServiceImplMock;
    @InjectMocks
    DynamicSearchCustomImpl dynamicSearchMock;

    @Mock
    EntityManagerFactory entityManagerFactory;
    @Mock
    EntityManager entityManager;
    @Mock
    CriteriaBuilder criteriaBuilder;
    @Mock
    CriteriaQuery<UserMaster> userMasterCriteriaQuery;
    @Mock
    Root<UserMaster> userMasterRoot;
    @Mock
    TypedQuery<UserMaster> typedQuery;

    UserMaster userMaster1;
    UserMaster userMaster1Updated;
    UserMaster userMaster2;

    List<UserMaster> users = new ArrayList<>();

    @Before
    public void setup(){
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


        users.add(userMaster1);
        users.add(userMaster2);
    }


    @Test
    public void insertTest(){
        doReturn(userMaster1).when(userMasterRepo).save(any());
        UserMaster expected = userMaster1;
        UserMaster actual = userServiceImplMock.insertMaster(userMaster1);
        Assert.assertEquals(expected,actual);
        verify(userMasterRepo).save(any());
    }

    @Test
    public void updateTest(){
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

        doReturn(userMaster1Updated).when(userMasterRepo).save(any());
        UserMaster expected = userMaster1Updated;
        when(userMasterRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(userMaster1));
        UserMaster actual = userServiceImplMock.updateMaster(userMaster1Updated , 1L);
        Assert.assertEquals(expected,actual);
        verify(userMasterRepo).save(any());
    }

    @Test
    public void selectByIdTest(){
        when(userMasterRepo.findById(anyLong())).thenReturn(Optional.of(userMaster1));
        UserMaster expected = userMaster1;
        UserMaster actual = userServiceImplMock.selectById(1);
        Assert.assertEquals(expected,actual);
        verify(userMasterRepo).findById(anyLong());
    }

    @Test
    public void selectAllTest(){
        doReturn(users).when(userMasterRepo).findAll();
        List<UserMaster> actualList = userServiceImplMock.selectAll();
        Assert.assertEquals(users,actualList);
        verify(userMasterRepo).findAll();
    }

    @Test
    public void deleteTest(){
        doNothing().doThrow(new IllegalStateException()).when(userMasterRepo).delete(any());
        userServiceImplMock.delete(userMaster1);
        verify(userMasterRepo).delete(any());
    }

    @Test
    public void dynamicSortTest(){
        users.sort(Comparator.comparing(UserMaster::getUserName));

        doReturn(users).when(userMasterRepo).findAll(any(Sort.class));
        List<UserMaster> actualList = userServiceImplMock.dynamicSort("userName");
        Assert.assertEquals(users,actualList);
        verify(userMasterRepo).findAll(Sort.by("userName").ascending());
    }

    @Test
    public void dynamicSearchByPinCodeTest(){
        when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(UserMaster.class)).thenReturn(userMasterCriteriaQuery);
        when(userMasterCriteriaQuery.from(UserMaster.class)).thenReturn(userMasterRoot);
        when(userMasterCriteriaQuery.select(userMasterRoot)).thenReturn(userMasterCriteriaQuery);
        when(entityManager.createQuery(userMasterCriteriaQuery)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(users);

        List<UserMaster> actualList = dynamicSearchMock.dynamicSearch("select user from UserMaster user where user.userDetail.pinCode='395006'");

        Assert.assertEquals(users,actualList);
        verify(dynamicSearchMock).dynamicSearch(anyString());
    }
}
