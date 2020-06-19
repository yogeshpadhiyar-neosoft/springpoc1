package com.neosoft.springPOC1.service;

import com.neosoft.springPOC1.model.UserContracts;
import com.neosoft.springPOC1.model.UserMaster;
import com.neosoft.springPOC1.repository.UserMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserMasterRepo userMasterRepo;

    @Autowired
    public UserServiceImpl(UserMasterRepo userMasterRepo) {
        this.userMasterRepo = userMasterRepo;
    }

    @Override
    public UserMaster selectById(long id) {
        return userMasterRepo.findById(id).orElse(null);
    }

    @Override
    public List<UserMaster> selectAll() {
        return userMasterRepo.findAll();
    }

    @Override
    public void delete(UserMaster userMaster) {
        userMasterRepo.delete(userMaster);
    }

    @Override
    public List<UserMaster> dynamicSort(String filed) {
        return userMasterRepo.findAll(Sort.by(filed).ascending());
    }

    @Override
    public UserMaster insertMaster(UserMaster userMaster) {
        userMaster.getUserDetail().setUserMaster(userMaster);
        userMaster.getUserEducation().setUserMaster(userMaster);
        userMaster.getUserEmployeementDetails().setUserMaster(userMaster);
        userMaster.getUserContracts().forEach(userContracts -> userContracts.setUserMaster(userMaster));
        userMaster.getUserRole().setUserMaster(userMaster);
        return userMasterRepo.save(userMaster);
    }

    @Override
    public UserMaster updateMaster(UserMaster userMaster , long id) {
        List<UserContracts> userContracts = selectById(id).getUserContracts();
        userMaster.setUserId(id);
        userMaster.getUserDetail().setUserDetailId(id);
        userMaster.getUserEducation().setUserEducationId(id);
        userMaster.getUserEmployeementDetails().setUserEmployeeId(id);
        userMaster.getUserRole().setRoleId(id);
        for (int i = 0; i < userMaster.getUserContracts().size(); i++) {
            userMaster.getUserContracts().get(i).setProjectId(userContracts.get(i).getProjectId());
        }
        return userMasterRepo.save(userMaster);
    }

}
