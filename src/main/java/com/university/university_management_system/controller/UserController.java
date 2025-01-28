package com.university.university_management_system.controller;


import com.university.university_management_system.model.UserModel;
import com.university.university_management_system.model.UserRoleModel;
import com.university.university_management_system.repository.UserRepository;
import com.university.university_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Tag (name = "User", description = "User endpoints" )

@RequestMapping("users")
public class UserController {



    @Autowired
    UserService userService;


    @GetMapping("")
    public ResponseEntity<List<UserModel>> getAll(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserModel> getUserByUuid(@PathVariable String uuid){
          return ResponseEntity.ok(userService.getUserByUuid(uuid));
    }

    @GetMapping("/searchuser")
    public ResponseEntity<List<UserModel>> searchUser(
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) Integer roleId,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge,
            @RequestParam(required = false) String gender) {

        List<UserModel> users = userService.searchUsers(email, userName, roleId, minAge, maxAge, gender);
        return ResponseEntity.ok(users);
    }
}
