package com.university.university_management_system.service;

import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.UserModel;
import com.university.university_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserModel> getAllUsers(){
        List<UserModel> allUsers = userRepository.findAll();
        if (allUsers.isEmpty()){
            throw new ApiException("No users",HttpStatus.NOT_FOUND);
        }
        return allUsers;
    }

    public UserModel getUserByUuid(String uuid){
        return userRepository.findById(uuid).orElseThrow(()->new ApiException("User not found",HttpStatus.NOT_FOUND));
    }

    public List<UserModel> searchUsers(String email, String userName, Integer roleId, Integer minAge, Integer maxAge, String gender) {
        List<UserModel> filteredUsers = new ArrayList<>();
        HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;
        if (email != null) {
            Optional.ofNullable(userRepository.findByEmail(email))
                    .map(Collections::singletonList)
                    .orElseThrow(() -> new ApiException("No user found with this email",NOT_FOUND));
        }

        if (userName != null) {
            return Optional.ofNullable(userRepository.findByUserName(userName))
                    .map(Collections::singletonList)
                    .orElseThrow(() -> new ApiException("No user found with this username",NOT_FOUND));
        }

        if (roleId != null) {
            return Optional.ofNullable(userRepository.findByRoleId(roleId))
                    .filter(users -> !users.isEmpty())
                    .orElseThrow(() -> new ApiException("No users found with this role",NOT_FOUND));
        }

        if (minAge != null && maxAge != null) {
            return Optional.ofNullable(userRepository.findByAgeRange(minAge, maxAge))
                    .filter(users -> !users.isEmpty())
                    .orElseThrow(() -> new ApiException("No users found in this age range",NOT_FOUND));
        }

        if (gender != null) {
            return Optional.ofNullable(userRepository.findByGender(gender))
                    .filter(users -> !users.isEmpty())
                    .orElseThrow(() -> new ApiException("No users found with this gender",NOT_FOUND));
        }


        return userRepository.findAll();
    }
}

