package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.SemesterCourseDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.SemesterCourseModel;
import com.university.university_management_system.model.SemesterModel;
import com.university.university_management_system.repository.SemesterCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SemesterCourseService {

    @Autowired
    SemesterCourseRepository semesterCourseRepository;

    public List<SemesterCourseDTO> getAll() {
        List<SemesterCourseModel> allCourses = semesterCourseRepository.findAll();
        if (allCourses.isEmpty()) {
            throw new ApiException("No Semester Courses found", HttpStatus.NOT_FOUND);
        }
        return allCourses.stream()
                .map(SemesterCourseDTO::fromModel)
                .toList();
    }

    public SemesterCourseDTO getBySemesterCourseId(int semesterCourseId) {
        SemesterCourseModel scm = semesterCourseRepository.findById(semesterCourseId)
                .orElseThrow(() -> new ApiException("No semesterCourse found for semesterCourseId: " + semesterCourseId, HttpStatus.NOT_FOUND));
        return SemesterCourseDTO.fromModel(scm);
    }

    public List<SemesterCourseDTO> getBySemesterId(int semesterId) {
        List<SemesterCourseModel> sc = semesterCourseRepository.getBySemesterId(semesterId);
        if (sc.isEmpty()) {
            throw new ApiException("No semester courses found for semester id: " + semesterId, HttpStatus.NOT_FOUND);
        }
        return sc.stream()
                .map(SemesterCourseDTO::fromModel)
                .toList();
    }

    public List<SemesterCourseDTO> getByCourseCode(String courseCode) {
        if (courseCode == null) {
            throw new ApiException("No course Code Found", HttpStatus.NOT_FOUND);
        }

        List<SemesterCourseModel> sc = semesterCourseRepository.getByCourseCode(courseCode);
        if (sc.isEmpty()) {
            throw new ApiException("No semester courses found for course code: " + courseCode, HttpStatus.NOT_FOUND);
        }
        return sc.stream()
                .map(SemesterCourseDTO::fromModel)
                .toList();
    }



}
