package com.university.university_management_system.controller;


import com.university.university_management_system.model.UserModel;
import com.university.university_management_system.model.UserRoleModel;
import com.university.university_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("users")
public class UserController {



    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public List<Map<String,Object>> getAll(){
        List<UserModel> users = userRepository.findAll();
        List<Map<String,Object>> usersWithoutPass = new ArrayList<>();
        for (UserModel user:users){
            usersWithoutPass.add(user.toJson(user));
        }
        return usersWithoutPass;
    }


}
