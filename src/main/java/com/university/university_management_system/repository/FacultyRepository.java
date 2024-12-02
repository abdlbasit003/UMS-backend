package com.university.university_management_system.repository;

import com.university.university_management_system.model.FacultyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<FacultyModel, Integer> {
}
