package com.university.university_management_system.model;


import jakarta.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userRoleId;

    @Column(name = "user_role_name", nullable = false)
    private String roleName;

    // Getters and Setters

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

