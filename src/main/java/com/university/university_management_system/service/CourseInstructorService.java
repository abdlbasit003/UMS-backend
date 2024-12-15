package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.CourseInstructorDTO;
import com.university.university_management_system.model.CourseInstructorModel;
import com.university.university_management_system.model.EnrolledCourseModel;
import com.university.university_management_system.repository.CourseInstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseInstructorService {

    @Autowired
    CourseInstructorRepository courseInstructorRepository;

    public List<CourseInstructorDTO> getAllCourseInstructors(){
        List<CourseInstructorModel> allCourseInstructors = courseInstructorRepository.findAll();
        List <CourseInstructorDTO> allCourseInstructorDtos = new ArrayList<>();

        for(CourseInstructorModel cim : allCourseInstructors){
            allCourseInstructorDtos.add(CourseInstructorDTO.fromModel(cim));
        }
        return allCourseInstructorDtos;
    }

    public CourseInstructorDTO getCourseInstructorbyId(int courseInstructorId){
       return CourseInstructorDTO.fromModel(courseInstructorRepository.findById(courseInstructorId).orElseThrow());
    }

    public List<CourseInstructorDTO> getCourseInstructorByCourseCode(String courseCode){
        List<CourseInstructorModel> allCourseInstructors = courseInstructorRepository.findAll();
        List<CourseInstructorDTO> courseInstructorsByCourseCode = new ArrayList<>();

        for(CourseInstructorModel cim : allCourseInstructors){
            if(courseCode.equals(cim.getCourse().getCourseCode())){
                courseInstructorsByCourseCode.add(CourseInstructorDTO.fromModel(cim));
            }
        }
        return courseInstructorsByCourseCode;
    }
    public List <CourseInstructorDTO> getInstructorsByFacultyId(int facultyId){
        List<CourseInstructorModel> allCourseInstructors = courseInstructorRepository.findAll();
        List<CourseInstructorDTO> courseInstructorsByFacultyId = new ArrayList<>();

        for(CourseInstructorModel cim : allCourseInstructors){
            if(facultyId == cim.getFaculty().getFacultyId()){
                courseInstructorsByFacultyId.add(CourseInstructorDTO.fromModel(cim));
            }
        }
        return courseInstructorsByFacultyId;
    }

    public List <CourseInstructorDTO> getCoursesByInstructorId(int facultyId){
        List<CourseInstructorModel> allCourseInstructors = courseInstructorRepository.findAll();
        List<CourseInstructorDTO> coursesByInstructor = new ArrayList<>();

        for (CourseInstructorModel cim : allCourseInstructors) {
            if (facultyId == cim.getFaculty().getFacultyId()) {
                coursesByInstructor.add(CourseInstructorDTO.fromModel(cim));
            }
        }
        return coursesByInstructor;
    }
}
