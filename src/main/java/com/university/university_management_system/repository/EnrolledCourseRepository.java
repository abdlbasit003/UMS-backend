package com.university.university_management_system.repository;

import com.university.university_management_system.DTOs.EnrolledCourseDTO;
import com.university.university_management_system.model.EnrolledCourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnrolledCourseRepository extends JpaRepository<EnrolledCourseModel, Integer> {



    @Query("SELECT ec FROM EnrolledCourseModel ec WHERE ec.student.studentId = :studentId")
    List<EnrolledCourseModel> getAllEnrolledCoursesByStudent(@Param("studentId") String studentId);



}
