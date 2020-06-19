//package com.neosoft.springPOC1.factoryMethod;
//
//import com.neosoft.springPOC1.model.UserDetail;
//import com.neosoft.springPOC1.model.UserMaster;
//import com.sun.xml.bind.v2.TODO;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//import org.powermock.api.mockito.PowerMockito;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@RunWith(SpringRunner.class)
//public class FactoryPattenTest {
//
//    @MockBean
//    FactoryPatten factoryPatten;
//
//
//    UserDetail yogi;
//    @Before
//    public void setup(){
//        UserMaster userMaster = new UserMaster(1,"yogi123","Yogi@123",true,new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()));
//        yogi = new UserDetail(userMaster,1L, "yogi", "padhiyar", "yogi1@gmail.com", "7777777777", new Date(1999, 5, 3), new Date(1999, 12, 1), 395006, true);
//    }
//
//    // TODO: 17/06/20 this testing method has error beacuse of factory patten testing....working on that.
//    @Test
//    public void userStringListTest(){
//        List<String> stringList = new ArrayList<>();
//        stringList.add(String.valueOf(yogi.getUserDetailId()));
//        stringList.add(yogi.getName());
//        stringList.add(yogi.getSurName());
//        stringList.add(yogi.getEmailID());
//        stringList.add(String.valueOf(yogi.getMobileNo()));
//        stringList.add(String.valueOf(yogi.getDOB()));
//        stringList.add(String.valueOf(yogi.getJoinDate()));
//        stringList.add(String.valueOf(yogi.getPinCode()));
//
//
//        PowerMockito.mockStatic(FactoryPatten.class);
//        PowerMockito.when(FactoryPatten.userStringList(Mockito.any(UserDetail.class))).thenReturn(stringList);
////        Assert.assertEquals(stringList,FactoryPatten.userStringList(yogi));
//        PowerMockito.verifyStatic(FactoryPatten.class);
//    }
//}
