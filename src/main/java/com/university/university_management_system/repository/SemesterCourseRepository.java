package com.university.university_management_system.repository;

import com.university.university_management_system.model.SemesterCourseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterCourseRepository extends JpaRepository<SemesterCourseModel,Integer> {
}
