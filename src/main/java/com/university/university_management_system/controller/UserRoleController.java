package com.university.university_management_system.controller;

import com.university.university_management_system.model.UserRoleModel;
import com.university.university_management_system.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userroles")
public class UserRoleController {

    @Autowired
    UserRoleRepository userRoleRepository;

    @GetMapping("")
    public List<UserRoleModel> getAllRoles() {
        return userRoleRepository.findAll();
    }

    @GetMapping("/{id}")
    public UserRoleModel getById(int id) {
        return userRoleRepository.findById(id).orElseThrow();

    }
}
