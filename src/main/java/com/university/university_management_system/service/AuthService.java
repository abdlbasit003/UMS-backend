package com.university.university_management_system.service;


import com.university.university_management_system.model.UserModel;
import com.university.university_management_system.repository.UserRepository;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.utils.SHA256Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthService {


    @Autowired
    UserRepository userRepository;


    public UserModel loginUser(String email, String password) {
        String passHash = SHA256Hashing.hashWithSHA256(password);
        UserModel user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(passHash)) {
            return user;
        }
        throw new ApiException("Invalid Credentials", HttpStatus.UNAUTHORIZED);

    }

    public UserModel forgotPassword(Map<String,String> body) {
        String oldPassHash = SHA256Hashing.hashWithSHA256(body.get("oldPassword"));
        UserModel user = userRepository.findByEmail(body.get("email"));

        if (user != null && user.getPassword().equals(oldPassHash)) {
            user.setPassword(SHA256Hashing.hashWithSHA256(body.get("newPassword")));
            userRepository.save(user); // Save the updated user
            return user;
        }
        throw new ApiException("Invalid Credentials",HttpStatus.UNAUTHORIZED);
    }


}
