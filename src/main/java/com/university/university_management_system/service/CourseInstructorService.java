package com.university.university_management_system.service;
import com.university.university_management_system.DTOs.CourseInstructorDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.CourseInstructorModel;
import com.university.university_management_system.model.CourseModel;
import com.university.university_management_system.repository.CourseInstructorRepository;
import com.university.university_management_system.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseInstructorService {

    @Autowired
    CourseInstructorRepository courseInstructorRepository;
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    FacultyService facultyService;

    public List<CourseInstructorDTO> getAllCourseInstructors(){
        List<CourseInstructorModel> allCourseInstructors = courseInstructorRepository.findAll();
        if (allCourseInstructors.isEmpty()){
            throw new ApiException("No Course Instructors", HttpStatus.NOT_FOUND);
        }
        return allCourseInstructors.stream().map(CourseInstructorDTO::fromModel).toList();
    }

    public CourseInstructorDTO getCourseInstructorbyId(int courseInstructorId){
       return CourseInstructorDTO.fromModel(courseInstructorRepository.findById(courseInstructorId).orElseThrow(()->new ApiException("Instructor not found",HttpStatus.NOT_FOUND)));
    }

    public List<CourseInstructorDTO> getCourseInstructorByCourseCode(String courseCode){
        courseRepository.findById(courseCode).orElseThrow(()->new ApiException("Invalid Course Code", HttpStatus.NOT_FOUND));
        List<CourseInstructorModel> allCourseInstructors = courseInstructorRepository.findAll();
        if (allCourseInstructors.isEmpty()){
            throw new ApiException("No Course Instructors", HttpStatus.NOT_FOUND);
        }

        return allCourseInstructors.stream().
                filter(ci->ci.getCourse().getCourseCode().equals(courseCode))
                .map(CourseInstructorDTO::fromModel).toList();
    }

    public List <CourseModel> getCoursesByInstructorId(int instructorId){
        facultyService.getFacultyById(instructorId);
        List<CourseInstructorModel> allCourseInstructors = courseInstructorRepository.findAll();
        if (allCourseInstructors.isEmpty()){
            throw new ApiException("No Course Instructors", HttpStatus.NOT_FOUND);
        }
        return allCourseInstructors.stream().
                filter(cim->cim.getFaculty().getFacultyId()==instructorId)
                .map(CourseInstructorModel::getCourse)
                .toList();
    }
}
