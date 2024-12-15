package com.university.university_management_system.service;
import com.university.university_management_system.DTOs.ExaminationRoomDTO;
import com.university.university_management_system.model.ExaminationRoomModel;
import com.university.university_management_system.repository.ExaminationRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<ExaminationRoomDTO> examRoomDTOs = new ArrayList<>();
        for (ExaminationRoomModel room : examRooms) {
            ExaminationRoomDTO dto = ExaminationRoomDTO.fromModel(room);
            examRoomDTOs.add(dto);
        }
        return examRoomDTOs;
    }

    public ExaminationRoomDTO getExaminationRoomById(int examinationRoomId) {
        ExaminationRoomModel examRooms = examinationRoomRepository.findById(examinationRoomId);
        ExaminationRoomDTO examRoomDto = null;
        if (examRooms != null) {
            examRoomDto = ExaminationRoomDTO.fromModel(examRooms);
        }
        return examRoomDto;
    }

    public List<ExaminationRoomDTO> getExaminationRoomsByExamId(int examId) {
        List<ExaminationRoomModel> examRooms = examinationRoomRepository.findByExamId(examId);
        List<ExaminationRoomDTO> roomDTOs = new ArrayList<>();
        for (ExaminationRoomModel rooms : examRooms) {
            ExaminationRoomDTO dto = ExaminationRoomDTO.fromModel(rooms);
            roomDTOs.add(dto);
        }
        return roomDTOs;
    }

    public List<ExaminationRoomDTO> getExaminationRoomsByStudentId(String studentId) {
        List<ExaminationRoomModel> examinationRooms = examinationRoomRepository.findByStudentId(studentId);
        List<ExaminationRoomDTO> roomDTOs = new ArrayList<>();
        for (ExaminationRoomModel room : examinationRooms) {
            ExaminationRoomDTO dto = ExaminationRoomDTO.fromModel(room);
            roomDTOs.add(dto);
        }
        return roomDTOs;
    }

    public List<ExaminationRoomDTO> getStudentsInExamHall(int examHallId) {
        List<ExaminationRoomModel> examinationRooms = examinationRoomRepository.findByExamHallId(examHallId);
        List<ExaminationRoomDTO> roomDTOs = new ArrayList<>();
        for (ExaminationRoomModel room : examinationRooms) {
            ExaminationRoomDTO dto = ExaminationRoomDTO.fromModel(room);
            roomDTOs.add(dto);
        }
        return roomDTOs;
    }
}
