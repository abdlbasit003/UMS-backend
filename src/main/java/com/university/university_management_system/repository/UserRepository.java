package com.university.university_management_system.repository;

import com.university.university_management_system.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<UserModel, String> {


    @Query("SELECT u from UserModel u WHERE u.userEmail = :email")
    UserModel findByEmail(@Param("email") String email);



}
