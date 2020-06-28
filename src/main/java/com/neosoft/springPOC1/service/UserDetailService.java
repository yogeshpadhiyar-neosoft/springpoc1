package com.neosoft.springPOC1.service;

import org.springframework.stereotype.Service;

@Service
public interface UserDetailService {

    /**
     * Check that email Id is exist in data base on not
     * @param email
     * @return
     */
    boolean emailIdExist(String email);
}
