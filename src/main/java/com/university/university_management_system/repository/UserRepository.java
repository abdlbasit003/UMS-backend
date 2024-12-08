package com.university.university_management_system.repository;

import com.university.university_management_system.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {



}
