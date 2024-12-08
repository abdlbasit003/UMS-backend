package com.university.university_management_system.repository;

import com.university.university_management_system.model.UserRoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoleModel,Integer> {
}
