package com.university.university_management_system.service;
import com.university.university_management_system.DTOs.CourseDepartmentDTO;
import com.university.university_management_system.DTOs.DepartmentDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.CourseModel;
import com.university.university_management_system.model.DepartmentCourseModel;
import com.university.university_management_system.repository.CourseRepository;
import com.university.university_management_system.repository.DepartmentCourseRepository;
import com.university.university_management_system.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
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
        return departmentCourses.stream().map(CourseDepartmentDTO::fromModel).toList();
    }

    public CourseDepartmentDTO getDepartmentCourseById(int departmentCourseId) {
        return CourseDepartmentDTO.fromModel(courseDepartmentRepository.findById(departmentCourseId).orElseThrow(()->new ApiException("Department not found", HttpStatus.NOT_FOUND)));
    }

    public List<CourseModel> getCoursesByDepartmentId(int departmentId) {
        departmentRepository.findById(departmentId).orElseThrow(()->new ApiException("Invalid department Id",HttpStatus.NOT_FOUND));
        List<DepartmentCourseModel> departmentCourses = courseDepartmentRepository.findAll();
        if (departmentCourses.isEmpty())throw new ApiException("Courses not found",HttpStatus.NOT_FOUND);
        return departmentCourses.stream().
                filter((dc)->dc.getDepartment().getDepartmentId()==departmentId).
                map(DepartmentCourseModel::getCourse).
                toList();


    }

    public List<DepartmentDTO> getDepartmentsByCourseCode(String courseCode) {
        courseRepository.findById(courseCode).orElseThrow(()->new ApiException("Invalid course code",HttpStatus.NOT_FOUND));
        List<DepartmentCourseModel> departmentCourses = courseDepartmentRepository.findAll();
        if (departmentCourses.isEmpty())throw new ApiException("No department teaches this course",HttpStatus.NOT_FOUND);

        List<DepartmentDTO> dtos =  departmentCourses.stream().
                filter(dc->dc.getCourse().getCourseCode().equals(courseCode)).
                map(DepartmentCourseModel::getDepartment).map(DepartmentDTO::fromModel).toList();
        if (dtos.isEmpty()){
            throw new ApiException("No courses taught in this department",HttpStatus.NOT_FOUND);
        }
        return dtos;
    }
}
