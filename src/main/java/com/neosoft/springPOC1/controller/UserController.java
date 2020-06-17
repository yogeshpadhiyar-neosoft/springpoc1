package com.neosoft.springPOC1.controller;

import com.neosoft.springPOC1.factoryMethod.FactoryPatten;
import com.neosoft.springPOC1.model.UserDetail;
import com.neosoft.springPOC1.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/poc1/userDetail")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/")
    public List<UserDetail> allUser() {
        return userServiceImpl.selectAll();
    }

    //Temp Solution return null. Leak of time.
    @PostMapping(value = "/add", consumes = "application/json")
    public UserDetail insertUser(@Valid @RequestBody UserDetail userDetail) {
        if(userDetail.getDOB().compareTo(userDetail.getJoinDate())<0)
            return userServiceImpl.insert(userDetail);
        else
            System.out.println("Please Enter proper JoinDate or DOB.");
        return null;
    }

    @PutMapping("/{userId}")
    public UserDetail updateUser(@PathVariable("userId") int id, @RequestBody UserDetail userDetail) {
        userDetail.setId(id);
        return userServiceImpl.update(userDetail);
    }


    @DeleteMapping("/softDelete/{userId}")
    public void softDelete(@PathVariable("userId") int id, @ModelAttribute UserDetail userDetail) {
        userDetail = userServiceImpl.selectById(id);
        userDetail.setStatus(false);
        userServiceImpl.update(userDetail);
    }

    @DeleteMapping("/hardDelete/{userId}")
    public void hardDelete(@PathVariable("userId") int id, @ModelAttribute UserDetail userDetail) {
        userDetail = userServiceImpl.selectById(id);
        userServiceImpl.delete(userDetail);
    }

    //dynamic search
    @GetMapping("/{object}")
    public List<UserDetail> dynamicSearch(@PathVariable("object") String object) {
        List<UserDetail> ls = new ArrayList<>();
        userServiceImpl.selectAll().forEach(user ->
        {
            if (FactoryPatten.userStringList(user).contains(object))
                ls.add(user);

        });
        return ls;
    }

    //dynamic sorting
    @GetMapping("/sortBy{field}")
    public List<UserDetail> sortBy(@PathVariable("field") String field) {
        return userServiceImpl.dynamicSort(field);
    }
}



