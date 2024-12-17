package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.CourseDepartmentDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.DepartmentCourseModel;
import com.university.university_management_system.repository.DepartmentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseDepartmentService {

    @Autowired
    private DepartmentCourseRepository courseDepartmentRepository;

    public List<CourseDepartmentDTO> getAllDepartmentCourses() {
        List<DepartmentCourseModel> departmentCourses = courseDepartmentRepository.findAll();
        List<CourseDepartmentDTO> result = new ArrayList<>();

        for (DepartmentCourseModel model : departmentCourses) {
            result.add(CourseDepartmentDTO.fromModel(model));
        }

        return result;
    }

    public CourseDepartmentDTO getDepartmentCourseById(int departmentCourseId) {
        DepartmentCourseModel model = courseDepartmentRepository.findById(departmentCourseId).orElseThrow(()->new ApiException("Department not found", HttpStatus.NOT_FOUND));

        if (model != null) {
            return CourseDepartmentDTO.fromModel(model);
        } else {
            throw new ApiException("DepartmentCourse not found with ID: " + departmentCourseId,HttpStatus.NOT_FOUND);
        }
    }

    public List<CourseDepartmentDTO> getCoursesByDepartmentId(int departmentId) {
        List<DepartmentCourseModel> departmentCourses = courseDepartmentRepository.findAll();
        List<CourseDepartmentDTO> result = new ArrayList<>();

        for (DepartmentCourseModel model : departmentCourses) {
            if (model.getDepartment().getDepartmentId() == departmentId) {
                result.add(CourseDepartmentDTO.fromModel(model));
            }
        }

        return result;
    }

    public List<CourseDepartmentDTO> getDepartmentsByCourseCode(String courseCode) {
        List<DepartmentCourseModel> departmentCourses = courseDepartmentRepository.findAll();
        List<CourseDepartmentDTO> result = new ArrayList<>();

        for (DepartmentCourseModel model : departmentCourses) {
            if (model.getCourse().getCourseCode().equals(courseCode)) {
                result.add(CourseDepartmentDTO.fromModel(model));
            }
        }

        return result;
    }

    public List<CourseDepartmentDTO> getAllCoursesInDepartment(String departmentName) {
        List<DepartmentCourseModel> departmentCourses = courseDepartmentRepository.findAll();
        List<CourseDepartmentDTO> result = new ArrayList<>();

        for (DepartmentCourseModel model : departmentCourses) {
            if (model.getDepartment().getDepartmentName().equalsIgnoreCase(departmentName)) {
                result.add(CourseDepartmentDTO.fromModel(model));
            }
        }

        return result;
    }
}
