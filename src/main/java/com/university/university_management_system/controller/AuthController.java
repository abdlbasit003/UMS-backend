package com.university.university_management_system.controller;

import com.university.university_management_system.model.UserModel;
import com.university.university_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


    @Autowired
    UserRepository userRepository;


    @GetMapping("/login")
    public UserModel loginUser(@RequestParam String email, @RequestParam String password){
        UserModel user = userRepository.findByEmail(email);
        if (user != null){
            if (user.getPassword().equals(password)){
                return user;
            }else{
                throw new IllegalArgumentException("Incorrect password");
            }
        }else{
            throw new IllegalArgumentException("Invalid email");
        }
    }


}
