package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.CourseDepartmentDTO;
import com.university.university_management_system.model.*;
import com.university.university_management_system.repository.DepartmentCourseRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CourseDepartmentService {

    private final DepartmentCourseRepository departmentCourseRepository;

    public CourseDepartmentService(DepartmentCourseRepository departmentCourseRepository) {
        this.departmentCourseRepository = departmentCourseRepository;
    }

    public List<CourseDepartmentDTO> getAllDepartmentCourses() {
        List<DepartmentCourseModel> models = departmentCourseRepository.findAll();
        return models.stream().map(CourseDepartmentDTO::fromModel).collect(Collectors.toList());
    }

    public CourseDepartmentDTO getDepartmentCourseById(int departmentCourseId) {
        DepartmentCourseModel model = departmentCourseRepository.findById(departmentCourseId)
                .orElseThrow(() -> new RuntimeException("Department Course not found with id: " + departmentCourseId));
        return CourseDepartmentDTO.fromModel(model);
    }

    public List<CourseDepartmentDTO> getCoursesByDepartmentId(int departmentId) {
        List<DepartmentCourseModel> models = departmentCourseRepository.findByDepartmentId(departmentId);
        return models.stream().map(CourseDepartmentDTO::fromModel).collect(Collectors.toList());
    }

    public List<CourseDepartmentDTO> getDepartmentsByCourseCode(String courseCode) {
        List<DepartmentCourseModel> models = departmentCourseRepository.findByCourseCode(courseCode);
        return models.stream().map(CourseDepartmentDTO::fromModel).collect(Collectors.toList());
    }

    public List<CourseDepartmentDTO> getAllCoursesInDepartment(String departmentName) {
        List<DepartmentCourseModel> models = departmentCourseRepository.findByDepartmentName(departmentName);
        return models.stream().map(CourseDepartmentDTO::fromModel).collect(Collectors.toList());
    }
}
