package com.neosoft.springPOC1.service;

import com.neosoft.springPOC1.model.UserDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDetail insert(UserDetail userDetail);

    UserDetail update(UserDetail userDetail);

    UserDetail selectById(int id);

    List<UserDetail> selectAll();

    void delete(UserDetail userDetail);

    List<UserDetail> dynamicSort(String filed);

}
