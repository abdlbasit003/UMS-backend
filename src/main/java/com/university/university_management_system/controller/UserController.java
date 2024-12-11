package com.university.university_management_system.controller;


import com.university.university_management_system.model.UserModel;
import com.university.university_management_system.model.UserRoleModel;
import com.university.university_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("users")
public class UserController {



    @Autowired
    UserRepository userRepository;


    @GetMapping("")
    public List<UserModel> getAll(){
        return userRepository.findAll();
    }

    @GetMapping("/{uuid}")
    public UserModel getUserByUuid(@PathVariable String uuid){
          return userRepository.findById(uuid).orElseThrow();
    }


}
