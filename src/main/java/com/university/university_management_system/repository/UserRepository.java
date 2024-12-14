package com.university.university_management_system.repository;

import com.university.university_management_system.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<UserModel, String> {


    @Query("SELECT u from UserModel u WHERE u.userEmail = :email")
    UserModel findByEmail(@Param("email") String email);

    @Query("SELECT u from UserModel u WHERE u.userRole.userRoleId = :roleId")
    List<UserModel> findByRoleId(@Param("roleId") int roleId);


    @Query("SELECT u from UserModel u WHERE u.userName = :userName")
    UserModel findByUserName(@Param("userName") String userName);

    @Query("SELECT u from UserModel u WHERE u.age >= :minAge AND u.age <= :maxAge")
    List<UserModel> findByAgeRange(@Param("minAge") int minAge,@Param("maxAge") int maxAge);

    @Query("SELECT u from UserModel u WHERE u.gender = :gender")
    List<UserModel> findByGender(@Param("gender") String gender);

}
