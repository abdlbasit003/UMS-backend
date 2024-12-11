package com.university.university_management_system.model;
import jakarta.persistence.*;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class UserModel{

    @Id
    @Column(name = "uuid", columnDefinition = "UUID")
    private String uuid;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "username")
    private String username;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_phone")
    private String userPhone;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRoleModel userRole;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserRoleModel getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleModel userRole) {
        this.userRole = userRole;
    }


}

