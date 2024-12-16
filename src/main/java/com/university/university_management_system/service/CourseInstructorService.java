package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.CourseInstructorDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.CourseInstructorModel;
import com.university.university_management_system.model.CourseModel;
import com.university.university_management_system.model.FacultyModel;
import com.university.university_management_system.repository.CourseInstructorRepository;
import com.university.university_management_system.repository.CourseRepository;
import com.university.university_management_system.repository.FacultyRepository;
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

    public List<CourseInstructorDTO> getAllCourseInstructors(){
        List<CourseInstructorModel> allCourseInstructors = courseInstructorRepository.findAll();
        List <CourseInstructorDTO> allCourseInstructorDtos = new ArrayList<>();

        if (allCourseInstructors.isEmpty()){
            throw new ApiException("No Course Instructors", HttpStatus.NOT_FOUND);
        }

        for(CourseInstructorModel cim : allCourseInstructors){
            allCourseInstructorDtos.add(CourseInstructorDTO.fromModel(cim));
        }
        return allCourseInstructorDtos;
    }

    public CourseInstructorDTO getCourseInstructorbyId(int courseInstructorId){
       return CourseInstructorDTO.fromModel(courseInstructorRepository.findById(courseInstructorId).orElseThrow(()->new ApiException("Instructor not found",HttpStatus.NOT_FOUND)));
    }


    public List<CourseInstructorDTO> getCourseInstructorByCourseCode(String courseCode){
        List<CourseInstructorModel> allCourseInstructors = courseInstructorRepository.findAll();
        List<CourseInstructorDTO> courseInstructorsByCourseCode = new ArrayList<>();
        CourseModel course = courseRepository.findById(courseCode).orElseThrow(()->new ApiException("Invalid Course Code", HttpStatus.NOT_FOUND));
        if (allCourseInstructors.isEmpty()){
            throw new ApiException("No Course Instructors", HttpStatus.NOT_FOUND);
        }

        for(CourseInstructorModel cim : allCourseInstructors){
            if(courseCode.equals(cim.getCourse().getCourseCode())){
                courseInstructorsByCourseCode.add(CourseInstructorDTO.fromModel(cim));
            }
        }
        return courseInstructorsByCourseCode;
    }

    public List <CourseModel> getCoursesByInstructorId(int instructorId){
        List<CourseInstructorModel> allCourseInstructors = courseInstructorRepository.findAll();
        List<CourseModel> coursesOfInstructor = new ArrayList<>();

        if (allCourseInstructors.isEmpty()){
            throw new ApiException("No Course Instructors", HttpStatus.NOT_FOUND);
        }
        for (CourseInstructorModel cim:allCourseInstructors){
            if (cim.getFaculty().getFacultyId() == instructorId){
                coursesOfInstructor.add(cim.getCourse());
            }
        }
        return coursesOfInstructor;
    }
}
