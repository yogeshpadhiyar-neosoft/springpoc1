package com.neosoft.springPOC1.service;

import com.neosoft.springPOC1.Constant.ErrorMessages;
import com.neosoft.springPOC1.exception.CustomMessage;
import com.neosoft.springPOC1.model.UserContracts;
import com.neosoft.springPOC1.model.UserMaster;
import com.neosoft.springPOC1.repository.UserMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
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
    public List<UserMaster> selectAll() throws CustomMessage{
        List<UserMaster> userMasterList =userMasterRepo.findAll();
        if(userMasterList.isEmpty())
            throw new CustomMessage(HttpStatus.BAD_REQUEST, ErrorMessages.ANY_USER_NOT_FOUND);
        return userMasterList;
    }

    @Override
    public UserMaster insertMaster(UserMaster userMaster) throws CustomMessage{
            return userMasterRepo.save(userMaster);

    }

    @Override
    public UserMaster selectById(long id)  throws CustomMessage{
        return userMasterRepo.findById(id).orElseThrow(()->new CustomMessage(HttpStatus.NO_CONTENT,ErrorMessages.NO_USER_FOUND));
    }

    @Override
    public void delete(UserMaster userMaster) {
        userMasterRepo.deleteById(userMaster.getUserId());
    }

    @Override
    public List<UserMaster> dynamicSort(String filed) throws CustomMessage {
        List<UserMaster> userMasterList = userMasterRepo.findAll(Sort.by(filed).ascending());
        if(userMasterList.isEmpty())
            throw new CustomMessage(HttpStatus.NO_CONTENT,ErrorMessages.ANY_USER_NOT_FOUND);
        else
            return userMasterRepo.findAll(Sort.by(filed).ascending());
    }

    @Override
    public UserMaster updateMaster(UserMaster userMaster , long id) throws CustomMessage{
        if(selectById(id)==null)
            throw new CustomMessage(HttpStatus.NO_CONTENT,ErrorMessages.NO_USER_FOUND);
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
