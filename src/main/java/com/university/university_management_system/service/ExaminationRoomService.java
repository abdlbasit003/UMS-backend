package com.university.university_management_system.service;
import com.university.university_management_system.DTOs.ExaminationRoomDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.ExaminationRoomModel;
import com.university.university_management_system.repository.ExaminationRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExaminationRoomService {

    @Autowired
    public ExaminationRoomRepository examinationRoomRepository;

    public ExaminationRoomService(ExaminationRoomRepository examinationRoomRepository) {
        this.examinationRoomRepository = examinationRoomRepository;
    }

    public List<ExaminationRoomDTO> getAllExaminationRooms() {
        List<ExaminationRoomModel> examRooms = examinationRoomRepository.findAll();
        if (!examRooms.isEmpty()) {
            List<ExaminationRoomDTO> examRoomDTOs = new ArrayList<>();
            for (ExaminationRoomModel room : examRooms) {
                ExaminationRoomDTO dto = ExaminationRoomDTO.fromModel(room);
                examRoomDTOs.add(dto);
            }
            return examRoomDTOs;
        }
        throw new ApiException("Not found", HttpStatus.NOT_FOUND);
    }

    public ExaminationRoomDTO getExaminationRoomById(int examinationRoomId) {
        ExaminationRoomModel examRooms = examinationRoomRepository.findById(examinationRoomId);
        if (examRooms.getExaminationRoomId() == examinationRoomId) {
            ExaminationRoomDTO examRoomDto = null;
            examRoomDto = ExaminationRoomDTO.fromModel(examRooms);
            return examRoomDto;
        }
        throw new ApiException("Not found", HttpStatus.NOT_FOUND);
    }

    public List<ExaminationRoomDTO> getExaminationRoomsByExamId(int examId) {
        List<ExaminationRoomModel> examRooms = examinationRoomRepository.findAll();
        if (!examRooms.isEmpty()) {
            List<ExaminationRoomDTO> roomDTOs = new ArrayList<>();
            for (ExaminationRoomModel rooms : examRooms) {
                if (rooms.getExam().getExamId() == examId) {
                    ExaminationRoomDTO dto = ExaminationRoomDTO.fromModel(rooms);
                    roomDTOs.add(dto);
                }
                return roomDTOs;
            }
        }
        throw new ApiException("Invalid Exam ID", HttpStatus.NOT_FOUND);
    }

    public List<ExaminationRoomDTO> getExaminationRoomsByStudentId(String studentId) {
        List<ExaminationRoomModel> examinationRooms = examinationRoomRepository.findAll();
        if (!examinationRooms.isEmpty()) {
            List<ExaminationRoomDTO> roomDTOs = new ArrayList<>();
            for (ExaminationRoomModel room : examinationRooms) {
                if (room.getStudent().getStudentId().equals(studentId)) {
                    ExaminationRoomDTO dto = ExaminationRoomDTO.fromModel(room);
                    roomDTOs.add(dto);
                }
                return roomDTOs;
            }
        }
        throw new ApiException("Invalid Student ID", HttpStatus.NOT_FOUND);
    }

    public List<ExaminationRoomDTO> getStudentsInExamHall(int examHallId) {
        List<ExaminationRoomModel> examinationRooms = examinationRoomRepository.findAll();
        if (!examinationRooms.isEmpty()) {
            List<ExaminationRoomDTO> roomDTOs = new ArrayList<>();
            for (ExaminationRoomModel room : examinationRooms) {
                if (room.getExam().getExamHall().getExamHallId() == examHallId) {
                    ExaminationRoomDTO dto = ExaminationRoomDTO.fromModel(room);
                    roomDTOs.add(dto);
                }
                return roomDTOs;
            }
        }
        throw new ApiException("Invalid ExamHall ID", HttpStatus.NOT_FOUND);
    }
}
