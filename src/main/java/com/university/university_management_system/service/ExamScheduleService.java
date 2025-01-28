package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.DepartmentDTO;
import com.university.university_management_system.DTOs.EnrolledCourseDTO;
import com.university.university_management_system.DTOs.ExamScheduleDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.CourseModel;
import com.university.university_management_system.model.EnrolledCourseModel;
import com.university.university_management_system.model.ExamScheduleModel;
import com.university.university_management_system.repository.ExamScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ExamScheduleService {

    @Autowired
    private ExamScheduleRepository examScheduleRepository;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
     private ExaminationRoomService examinationRoomService;
    @Autowired
    private EnrolledCourseService enrolledCourseService;
    @Autowired
    private CourseDepartmentService courseDepartmentService;

    // Get all exam schedules
    public List<ExamScheduleDTO> getAll() {
        List<ExamScheduleModel> schedules = examScheduleRepository.findAll();
        if (schedules.isEmpty()) {
            throw new ApiException("Schedule not found", HttpStatus.NOT_FOUND);
        }
        return schedules.stream()
                .map(ExamScheduleDTO::fromModel)
                .toList();
    }

    public ExamScheduleDTO getByScheduleId(int scheduleId) {
        ExamScheduleModel model = examScheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ApiException("Schedule not found with ID: " + scheduleId, HttpStatus.NOT_FOUND));
        return ExamScheduleDTO.fromModel(model);
    }

    public List<ExamScheduleDTO> getByExamId(int examId) {
        List<ExamScheduleModel> schedules = examScheduleRepository.findAll();
        if (schedules.isEmpty()) {
            throw new ApiException("Schedule not found", HttpStatus.NOT_FOUND);
        }
        return schedules.stream()
                .filter(model -> model.getExam().getExamId() == examId)
                .map(ExamScheduleDTO::fromModel)
                .toList();
    }

    public List<ExamScheduleDTO> getByExaminationRoomId(int roomId) {
        List<ExamScheduleModel> schedules = examScheduleRepository.findAll();
        if (schedules.isEmpty()) {
            throw new ApiException("Schedule not found", HttpStatus.NOT_FOUND);
        }
        return schedules.stream()
                .filter(model -> model.getExaminationRoom().getExaminationRoomId() == roomId)
                .map(ExamScheduleDTO::fromModel)
                .toList();
    }

    public List<ExamScheduleDTO> getByStartTime(LocalTime startTime) {
        List<ExamScheduleModel> schedules = examScheduleRepository.findAll();
        if (schedules.isEmpty()) {
            throw new ApiException("Schedule not found for start time " + startTime, HttpStatus.NOT_FOUND);
        }
        return schedules.stream()
                .filter(model -> model.getStartTime().equals(startTime))
                .map(ExamScheduleDTO::fromModel)
                .toList();
    }

    public List<ExamScheduleDTO> getByEndTime(LocalTime endTime) {
        List<ExamScheduleModel> schedules = examScheduleRepository.findAll();
        if (schedules.isEmpty()) {
            throw new ApiException("Schedule not found for end time " + endTime, HttpStatus.NOT_FOUND);
        }
        return schedules.stream()
                .filter(model -> model.getEndTime().equals(endTime))
                .map(ExamScheduleDTO::fromModel)
                .toList();
    }

    public List<ExamScheduleDTO> getByExamDate(LocalDate examDate) {
        List<ExamScheduleModel> schedules = examScheduleRepository.findAll();
        if (schedules.isEmpty()) {
            throw new ApiException("No schedules found for the exam date: " + examDate, HttpStatus.NOT_FOUND);
        }
        return schedules.stream()
                .filter(model -> model.getExamDate().equals(examDate))
                .map(ExamScheduleDTO::fromModel)
                .toList();
    }

    public List<ExamScheduleDTO> getCompleteScheduleOfDepartment(int departmentId) {
        List<CourseModel> departmentCourses = courseDepartmentService.getCoursesByDepartmentId(departmentId);
        if (departmentCourses.isEmpty()) {
            throw new ApiException("No courses found for the department with ID: " + departmentId, HttpStatus.NOT_FOUND);
        }
        List<ExamScheduleModel> schedules = examScheduleRepository.findAll();
        if (schedules.isEmpty()) {
            throw new ApiException("No exam schedules found in the system.", HttpStatus.NOT_FOUND);
        }
        List<ExamScheduleDTO> examScheduleDTOS = new ArrayList<>();
        for (ExamScheduleModel model : schedules) {
            for (CourseModel departmentCourse : departmentCourses) {
                if (model.getExam().getCourse().getCourseCode().equals(departmentCourse.getCourseCode())) {
                    examScheduleDTOS.add(ExamScheduleDTO.fromModel(model));
                }
            }
        }
        if (examScheduleDTOS.isEmpty()) {
            throw new ApiException("No exam schedules found for the department with ID: " + departmentId, HttpStatus.NOT_FOUND);
        }
        return examScheduleDTOS;
    }

    public List<ExamScheduleDTO> getCompleteScheduleOfStudent(String studentId) {
        List<EnrolledCourseDTO> enrolledCourseDTOS = enrolledCourseService.getCoursesByStudentId(studentId);
        List<ExamScheduleModel> schedules = examScheduleRepository.findAll();
        if (schedules.isEmpty() || enrolledCourseDTOS.isEmpty()) {
            throw new ApiException("Schedule not found for respective student ID " + studentId, HttpStatus.NOT_FOUND);
        }
        List<ExamScheduleDTO> examScheduleDTOS = new ArrayList<>();
        for (ExamScheduleModel model : schedules) {
            for (EnrolledCourseDTO enrolledCourse : enrolledCourseDTOS) {
                if (model.getExaminationRoom().getStudent().getStudentId().equals(enrolledCourse.getStudent().getStudentId())) {
                    examScheduleDTOS.add(ExamScheduleDTO.fromModel(model));
                }
            }
        }
        return examScheduleDTOS;
    }

    public List<ExamScheduleDTO> getByCourse(String courseCode) {
        List<ExamScheduleModel> schedules = examScheduleRepository.findAll();
        if (schedules.isEmpty()) {
            throw new ApiException("Schedule not found for Course " + courseCode, HttpStatus.NOT_FOUND);
        }
        return schedules.stream()
                .filter(model -> model.getExam().getCourse().getCourseCode().equals(courseCode))
                .map(ExamScheduleDTO::fromModel)
                .toList();
    }



}
