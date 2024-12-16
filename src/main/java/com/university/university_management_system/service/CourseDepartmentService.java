package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.CourseDepartmentDTO;
import com.university.university_management_system.model.DepartmentCourseModel;
import com.university.university_management_system.model.DepartmentModel;
import com.university.university_management_system.model.CourseModel;
import com.university.university_management_system.repository.DepartmentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CourseDepartmentService {

    @Autowired
    private final DepartmentCourseRepository departmentCourseRepository;

    public CourseDepartmentService(DepartmentCourseRepository departmentCourseRepository) {
        this.departmentCourseRepository = departmentCourseRepository;
    }

    public List<CourseDepartmentDTO> getAllDepartmentCourses() {
        List<DepartmentCourseModel> departmentCourseModels = departmentCourseRepository.findAll();
        List<CourseDepartmentDTO> departmentCourseDTOs = new ArrayList<>();
        for (DepartmentCourseModel model : departmentCourseModels) {
            departmentCourseDTOs.add(CourseDepartmentDTO.fromModel(model));
        }
        return departmentCourseDTOs;
    }

    public CourseDepartmentDTO getDepartmentCourseById(int departmentCourseId) {
        DepartmentCourseModel model = departmentCourseRepository.findById(departmentCourseId)
                .orElseThrow(() -> new RuntimeException("Department Course not found"));
        return CourseDepartmentDTO.fromModel(model);
    }

    public List<CourseDepartmentDTO> getCoursesByDepartmentId(int departmentId) {
        List<DepartmentCourseModel> departmentCourseModels = departmentCourseRepository.findByDepartmentId(departmentId);
        List<CourseDepartmentDTO> departmentCourseDTOs = new ArrayList<>();
        for (DepartmentCourseModel model : departmentCourseModels) {
            departmentCourseDTOs.add(CourseDepartmentDTO.fromModel(model));
        }
        return departmentCourseDTOs;
    }

    public List<CourseDepartmentDTO> getDepartmentsByCourseCode(String courseCode) {
        List<DepartmentCourseModel> departmentCourseModels = departmentCourseRepository.findByCourseCode(courseCode);
        List<CourseDepartmentDTO> departmentCourseDTOs = new ArrayList<>();
        for (DepartmentCourseModel model : departmentCourseModels) {
            departmentCourseDTOs.add(CourseDepartmentDTO.fromModel(model));
        }
        return departmentCourseDTOs;
    }

    public List<CourseDepartmentDTO> getAllCoursesInDepartment(String departmentName) {
        List<DepartmentCourseModel> departmentCourseModels = departmentCourseRepository.findByDepartmentName(departmentName);
        List<CourseDepartmentDTO> departmentCourseDTOs = new ArrayList<>();
        for (DepartmentCourseModel model : departmentCourseModels) {
            departmentCourseDTOs.add(CourseDepartmentDTO.fromModel(model));
        }
        return departmentCourseDTOs;
    }
}
