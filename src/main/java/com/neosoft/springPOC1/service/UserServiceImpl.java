package com.neosoft.springPOC1.service;

import com.neosoft.springPOC1.model.UserDetail;
import com.neosoft.springPOC1.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDetailRepository userDetailRepository;

    @Autowired
    public UserServiceImpl(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public UserDetail insert(UserDetail userDetail) {
        return userDetailRepository.save(userDetail);
    }

    @Override
    public UserDetail update(UserDetail userDetail) {
        return userDetailRepository.save(userDetail);
    }

    @Override
    public UserDetail selectById(int id) {
        return userDetailRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserDetail> selectAll() {
        return userDetailRepository.findAll();
    }

    @Override
    public void delete(UserDetail userDetail) {
        userDetailRepository.delete(userDetail);
    }

    @Override
    public List<UserDetail> dynamicSort(String filed) {
        return userDetailRepository.findAll(Sort.by(filed).ascending());
    }
}
