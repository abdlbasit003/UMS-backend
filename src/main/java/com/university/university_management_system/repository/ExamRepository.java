package com.university.university_management_system.repository;

import com.university.university_management_system.model.ExamModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<ExamModel, Integer> {

    @Query("SELECT e FROM ExamModel e WHERE e.course.courseCode = :courseCode")
    List<ExamModel> getExamsByCourseCode(@Param("courseCode") String courseCode);

}
