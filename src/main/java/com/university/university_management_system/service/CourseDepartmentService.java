package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.CourseDepartmentDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.DepartmentCourseModel;
import com.university.university_management_system.model.DepartmentModel;
import com.university.university_management_system.repository.CourseRepository;
import com.university.university_management_system.repository.DepartmentCourseRepository;
import com.university.university_management_system.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseDepartmentService {

    @Autowired
    private DepartmentCourseRepository courseDepartmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<CourseDepartmentDTO> getAllDepartmentCourses() {
        List<DepartmentCourseModel> departmentCourses = courseDepartmentRepository.findAll();
        if (departmentCourses.isEmpty())throw new ApiException("Courses not found",HttpStatus.NOT_FOUND);
        List<CourseDepartmentDTO> result = new ArrayList<>();
        for (DepartmentCourseModel model : departmentCourses) {
            result.add(CourseDepartmentDTO.fromModel(model));
        }
        return result;
    }

    public CourseDepartmentDTO getDepartmentCourseById(int departmentCourseId) {
        return CourseDepartmentDTO.fromModel(courseDepartmentRepository.findById(departmentCourseId).orElseThrow(()->new ApiException("Department not found", HttpStatus.NOT_FOUND)));
    }

    public List<CourseDepartmentDTO> getCoursesByDepartmentId(int departmentId) {
        departmentRepository.findById(departmentId).orElseThrow(()->new ApiException("Invalid department Id",HttpStatus.NOT_FOUND));
        List<DepartmentCourseModel> departmentCourses = courseDepartmentRepository.findAll();
        if (departmentCourses.isEmpty())throw new ApiException("Courses not found",HttpStatus.NOT_FOUND);
        List<CourseDepartmentDTO> result = new ArrayList<>();
        for (DepartmentCourseModel model : departmentCourses) {
            if (model.getDepartment().getDepartmentId() == departmentId) {
                result.add(CourseDepartmentDTO.fromModel(model));
            }
        }
        if (result.isEmpty())throw new ApiException("Courses not found in this department",HttpStatus.NOT_FOUND);

        return result;
    }

    public List<CourseDepartmentDTO> getDepartmentsByCourseCode(String courseCode) {
        courseRepository.findById(courseCode).orElseThrow(()->new ApiException("Invalid course code",HttpStatus.NOT_FOUND));
        List<DepartmentCourseModel> departmentCourses = courseDepartmentRepository.findAll();
        if (departmentCourses.isEmpty())throw new ApiException("Courses not found",HttpStatus.NOT_FOUND);
        List<CourseDepartmentDTO> result = new ArrayList<>();

        for (DepartmentCourseModel model : departmentCourses) {
            if (model.getCourse().getCourseCode().equals(courseCode)) {
                result.add(CourseDepartmentDTO.fromModel(model));
            }
        }
        if (result.isEmpty())throw new ApiException("Courses not found in this department",HttpStatus.NOT_FOUND);
        return result;
    }

    public List<CourseDepartmentDTO> getAllCoursesInDepartment(String departmentName) {
        List<DepartmentCourseModel> departmentCourses = courseDepartmentRepository.findAll();
        if (departmentCourses.isEmpty())throw new ApiException("Courses not found",HttpStatus.NOT_FOUND);
        List<CourseDepartmentDTO> result = new ArrayList<>();

        for (DepartmentCourseModel model : departmentCourses) {
            if (model.getDepartment().getDepartmentName().equalsIgnoreCase(departmentName)) {
                result.add(CourseDepartmentDTO.fromModel(model));
            }
        }
        if (result.isEmpty())throw new ApiException("Courses not found in this department",HttpStatus.NOT_FOUND);
        return result;
    }
}
