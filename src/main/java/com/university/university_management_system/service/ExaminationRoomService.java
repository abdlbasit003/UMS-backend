package com.university.university_management_system.service;
import com.university.university_management_system.DTOs.ExaminationRoomDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.ExamHallModel;
import com.university.university_management_system.model.ExamModel;
import com.university.university_management_system.model.ExaminationRoomModel;
import com.university.university_management_system.model.StudentModel;
import com.university.university_management_system.repository.ExamHallRepository;
import com.university.university_management_system.repository.ExamRepository;
import com.university.university_management_system.repository.ExaminationRoomRepository;
import com.university.university_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExaminationRoomService {

    @Autowired
    private ExaminationRoomRepository examinationRoomRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    ExamHallRepository examHallRepository;

    @Autowired
    ExamRepository examRepository;


    public List<ExaminationRoomDTO> getAllExaminationRooms() {
        return examinationRoomRepository.findAll()
                .stream().map(ExaminationRoomDTO::fromModel)
                .toList();
    }

    public ExaminationRoomDTO getExaminationRoomById(int examinationRoomId) {

        return ExaminationRoomDTO.fromModel(examinationRoomRepository.findById(examinationRoomId)
                .orElseThrow(() -> new ApiException("Not found", HttpStatus.NOT_FOUND)));

    }


    public List<ExaminationRoomDTO> getExaminationRoomsByExamId(int examId) {
        ExamModel examModel = examRepository.findById(examId)
                .orElseThrow(() -> new ApiException("No exam rooms found", HttpStatus.NOT_FOUND));
        return examinationRoomRepository.findAll().stream()
                .filter(rooms -> rooms.getExam().getExamId() == examId)
                .map(ExaminationRoomDTO::fromModel)
                .toList();
    }


    public List<ExaminationRoomDTO> getExaminationRoomsByStudentId(String studentId) {
        StudentModel student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ApiException("No exam rooms found", HttpStatus.NOT_FOUND));
        return examinationRoomRepository.findAll().stream()
                .filter(room -> room.getStudent().getStudentId().equals(studentId))
                .map(ExaminationRoomDTO::fromModel)
                .toList();
    }



}
