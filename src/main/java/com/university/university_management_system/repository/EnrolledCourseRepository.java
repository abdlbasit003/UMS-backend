package com.university.university_management_system.repository;

import com.university.university_management_system.model.EnrolledCourseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolledCourseRepository extends JpaRepository<EnrolledCourseModel, Integer> {
}
