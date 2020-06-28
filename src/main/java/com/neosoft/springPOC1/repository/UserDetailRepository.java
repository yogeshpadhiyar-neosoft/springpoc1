package com.neosoft.springPOC1.repository;

import com.neosoft.springPOC1.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    @Query("select user from UserDetail user where user.status=true ")
    List<UserDetail> findAll();


    boolean existsUserDetailByEmailId(String emailId);
}
