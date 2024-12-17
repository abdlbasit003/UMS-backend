package com.university.university_management_system.repository;
import com.university.university_management_system.model.CLOModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CLORepository extends JpaRepository<CLOModel, Integer> {

    @Query("SELECT clo FROM CLOModel clo WHERE clo.course.courseCode = :courseCode")
    List<CLOModel> getCLOsByCourseCode(@Param("courseCode") String courseCode);
}
