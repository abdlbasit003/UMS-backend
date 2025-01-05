package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.CourseResultDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.CourseResultModel;
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

    // Get all course results
    public List<CourseResultDTO> getAll() {
        try {
            List<CourseResultDTO> results = new ArrayList<>();
            List<CourseResultModel> courseResultModels = courseResultRepository.findAll();
            for (CourseResultModel courseResultModel : courseResultModels) {
                results.add(CourseResultDTO.fromModel(courseResultModel));
            }
            return results;
        } catch (Exception e) {
            throw new ApiException("Error retrieving all course results", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get course result by ID
    public CourseResultDTO getByCourseResultId(int courseResultId) {
        try {
            Optional<CourseResultModel> optionalCourseResult = courseResultRepository.findById(courseResultId);
            if (optionalCourseResult.isEmpty()) {
                throw new ApiException("Cannot find the result by this CourseResultId", HttpStatus.NOT_FOUND);
            }
            return CourseResultDTO.fromModel(optionalCourseResult.get());
        } catch (Exception e) {
            throw new ApiException("Error retrieving course result by ID", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get course results by student ID
    public List<CourseResultDTO> getByStudentId(int studentId) {
        try {
            List<CourseResultModel> courseResults = new ArrayList<>();
            List<CourseResultModel> allResults = courseResultRepository.findAll();
            for (CourseResultModel result : allResults) {
                if (result.getStudent().getStudentId().equals(studentId)) {
                    courseResults.add(result);
                }
            }

            if (courseResults.isEmpty()) {
                throw new ApiException("No results found for the given StudentId", HttpStatus.NOT_FOUND);
            }

            List<CourseResultDTO> resultDTOs = new ArrayList<>();
            for (CourseResultModel courseResult : courseResults) {
                resultDTOs.add(CourseResultDTO.fromModel(courseResult));
            }
            return resultDTOs;
        } catch (Exception e) {
            throw new ApiException("Error retrieving course results by StudentId", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get course results by course code
    public List<CourseResultDTO> getByCourseCode(String courseCode) {
        try {
            List<CourseResultModel> courseResults = new ArrayList<>();
            List<CourseResultModel> allResults = courseResultRepository.findAll();
            for (CourseResultModel result : allResults) {
                if (result.getCourse().getCourseCode().equals(courseCode)) {
                    courseResults.add(result);
                }
            }

            if (courseResults.isEmpty()) {
                throw new ApiException("No results found for the given CourseCode", HttpStatus.NOT_FOUND);
            }

            List<CourseResultDTO> resultDTOs = new ArrayList<>();
            for (CourseResultModel courseResult : courseResults) {
                resultDTOs.add(CourseResultDTO.fromModel(courseResult));
            }
            return resultDTOs;
        } catch (Exception e) {
            throw new ApiException("Error retrieving course results by CourseCode", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get course results by exam ID
    public List<CourseResultDTO> getByExamId(int examId) {
        try {
            List<CourseResultModel> courseResults = new ArrayList<>();
            List<CourseResultModel> allResults = courseResultRepository.findAll();
            for (CourseResultModel result : allResults) {
                if (result.getExam().getExamId() == examId) {
                    courseResults.add(result);
                }
            }

            if (courseResults.isEmpty()) {
                throw new ApiException("No results found for the given ExamId", HttpStatus.NOT_FOUND);
            }

            List<CourseResultDTO> resultDTOs = new ArrayList<>();
            for (CourseResultModel courseResult : courseResults) {
                resultDTOs.add(CourseResultDTO.fromModel(courseResult));
            }
            return resultDTOs;
        } catch (Exception e) {
            throw new ApiException("Error retrieving course results by ExamId", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get course results by student ID and semester ID
    public List<CourseResultDTO> getBySemesterId(String studentId, int semesterId) {
        try {
            List<CourseResultModel> courseResults = new ArrayList<>();
            List<CourseResultModel> allResults = courseResultRepository.findAll();
            for (CourseResultModel result : allResults) {
                if (result.getStudent().getStudentId().equals(studentId) && result.getStudent().getSemester().getSemesterId() == (semesterId)) {
                    courseResults.add(result);
                }
            }

            if (courseResults.isEmpty()) {
                throw new ApiException("No results found for the given StudentId and SemesterId", HttpStatus.NOT_FOUND);
            }

            List<CourseResultDTO> resultDTOs = new ArrayList<>();
            for (CourseResultModel courseResult : courseResults) {
                resultDTOs.add(CourseResultDTO.fromModel(courseResult));
            }
            return resultDTOs;
        } catch (Exception e) {
            throw new ApiException("Error retrieving course results by StudentId and SemesterId", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
