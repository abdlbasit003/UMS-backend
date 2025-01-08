package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.CourseResultDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.CourseResultModel;
import com.university.university_management_system.repository.CourseRepository;
import com.university.university_management_system.repository.CourseResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseResultService {

    @Autowired
    private CourseResultRepository courseResultRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentService studentService;

    @Autowired
    ExamService examService;

    @Autowired
    SemesterService semesterService;

    public List<CourseResultDTO> getAll() {
        try {
            return courseResultRepository.findAll().stream().map(CourseResultDTO::fromModel).toList();
        } catch (ApiException e) {
            throw new ApiException("Error retrieving all course results", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get course result by ID
    public CourseResultDTO getByCourseResultId(int courseResultId) {
        return CourseResultDTO.fromModel(courseResultRepository.findById(courseResultId).orElseThrow(()-> new ApiException("Cannot find the result by this CourseResultId", HttpStatus.NOT_FOUND)));
    }

    // Get course results by student ID
    public List<CourseResultDTO> getByStudentId(String studentId) {
        studentService.getStudentById(studentId);
        return courseResultRepository.findAll()
                .stream().filter(crm->crm.getStudent().getStudentId().equals(studentId))
                .map(CourseResultDTO::fromModel)
                .toList();
    }

    public List<CourseResultDTO> getByCourseCode(String courseCode) {
        courseRepository.findById(courseCode).orElseThrow(()->new ApiException("No results found for the given CourseCode", HttpStatus.NOT_FOUND));
        return courseResultRepository.findAll()
                .stream().filter(crm->crm.getCourse().getCourseCode().equals(courseCode))
                .map(CourseResultDTO::fromModel)
                .toList();
    }

    public List<CourseResultDTO> getByExamId(int examId) {
        examService.getExamById(examId);
        return courseResultRepository.findAll()
                .stream().filter(crm->crm.getExam().getExamId()==examId)
                .map(CourseResultDTO::fromModel)
                .toList();

    }

    public List<CourseResultDTO> getBySemesterId(String studentId, int semesterId) {
        studentService.getStudentById(studentId);
        semesterService.getBySemesterId(semesterId);
        return courseResultRepository.findAll()
                .stream().filter(cim->cim.getStudent().getStudentId().equals(studentId)&&cim.getStudent().getSemester().getSemesterId()==semesterId)
                .map(CourseResultDTO::fromModel)
                .toList();
    }

}
