package com.neosoft.springPOC1.service;

import com.neosoft.springPOC1.model.UserDetail;
import com.neosoft.springPOC1.model.UserMaster;
import com.neosoft.springPOC1.model.UserWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    /**
     * Use of find all data of user using userID
     * @param id
     * @return userMaster
     */
    UserMaster selectById(long id);


    /**
     * Find all data from database
     * @return list<UserMaster>
     */
    List<UserMaster> selectAll();


    /**
     * delete user from database
     * hard delete
     * @param userMaster
     */
    void delete(UserMaster userMaster);


    /**
     * dynamic sorting using ModelName nad filed
     * @param filed
     * @return sortlist List<UserMaster>
     */
    List<UserMaster> dynamicSort(String filed);


    /**
     * insert user data
     * @param userMaster
     * @return iserted user data
     */
    UserMaster insertMaster(UserMaster userMaster);


    /**
     * update user data passing userID
     * @param userMaster
     * @param id
     * @return updated user data
     */
    UserMaster updateMaster(UserMaster userMaster,long id);


}
