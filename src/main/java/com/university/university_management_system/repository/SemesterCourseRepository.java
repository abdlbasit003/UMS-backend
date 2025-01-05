package com.university.university_management_system.repository;

import com.university.university_management_system.DTOs.SemesterCourseDTO;
import com.university.university_management_system.model.SemesterCourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SemesterCourseRepository extends JpaRepository<SemesterCourseModel,Integer> {

    @Query("SELECT s FROM SemesterCourseModel s WHERE s.semester.semesterId = :semesterId")
    List<SemesterCourseModel> getBySemesterId( @Param("semesterId") int semesterId);

    @Query("SELECT s FROM SemesterCourseModel s WHERE s.course.courseCode = :courseCode")
    List<SemesterCourseModel> getByCourseCode(@Param("courseCode") String courseCode);
}
