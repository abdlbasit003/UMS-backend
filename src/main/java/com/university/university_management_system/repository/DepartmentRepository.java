package com.university.university_management_system.repository;

import com.university.university_management_system.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentModel, Integer> {
}
