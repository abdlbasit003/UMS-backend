package com.university.university_management_system.repository;

import com.university.university_management_system.model.SemesterModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<SemesterModel,Integer> {
}
