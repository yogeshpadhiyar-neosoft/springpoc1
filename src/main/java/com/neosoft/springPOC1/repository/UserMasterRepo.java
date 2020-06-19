package com.neosoft.springPOC1.repository;

import com.neosoft.springPOC1.model.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface UserMasterRepo extends JpaRepository<UserMaster,Long> {

    @Query("select user from UserMaster user where user.active=true ")
    List<UserMaster> findAll();


    @Query(value="select * from user_master user where user.userDetails.name=yogi and user.userDetails.surName=padhiyar", nativeQuery = true)
    List<UserMaster> findAllByUserId();

}
