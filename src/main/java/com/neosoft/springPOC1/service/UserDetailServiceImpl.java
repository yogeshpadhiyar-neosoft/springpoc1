package com.neosoft.springPOC1.service;

import com.neosoft.springPOC1.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl  implements UserDetailService{

    private final UserDetailRepository userDetailRepository;
    @Autowired
    public UserDetailServiceImpl(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public boolean emailIdExist(String email) {
        return userDetailRepository.existsUserDetailByEmailId(email);
    }
}
