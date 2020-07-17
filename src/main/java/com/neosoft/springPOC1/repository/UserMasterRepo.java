package com.neosoft.springPOC1.repository;

import com.neosoft.springPOC1.model.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserMasterRepo extends JpaRepository<UserMaster,Long> {

    @Query("select user from UserMaster user where user.active=true ")
    List<UserMaster> findAll();


    Optional<UserMaster> findByUserDetail_EmailId(String userName);
}
