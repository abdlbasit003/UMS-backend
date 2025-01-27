package com.university.university_management_system.controller;


import com.university.university_management_system.model.UserModel;
import com.university.university_management_system.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Tag(name = "Authentication", descirption = "Auth endpoints")
public class AuthController {


    @Autowired
    AuthService authService;


    @GetMapping("/login")
    public ResponseEntity<UserModel> loginUser(@RequestParam String email, @RequestParam String password){
        return ResponseEntity.ok(authService.loginUser(email,password));
    }

    @PutMapping("/forgotpass")
    public ResponseEntity<UserModel> forgotPass(@RequestBody Map<String,String> body){
        return ResponseEntity.ok(authService.forgotPassword(body));

    }


}
