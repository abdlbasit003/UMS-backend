package com.university.university_management_system.repository;

import com.university.university_management_system.model.DepartmentCourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentCourseRepository extends JpaRepository<DepartmentCourseModel, Integer> {
    //CHANGES MADE BY RAYYAN ASIM : TO RUN CourseDepartmentService
    List<DepartmentCourseModel> findByDepartmentId(int departmentId);
    //CHANGES MADE BY RAYYAN ASIM : TO RUN CourseDepartmentService
    List<DepartmentCourseModel> findByCourseCode(String courseCode);
    //CHANGES MADE BY RAYYAN ASIM  : TO RUN CourseDepartmentService
    List<DepartmentCourseModel> findByDepartmentName(String departmentName);

}
