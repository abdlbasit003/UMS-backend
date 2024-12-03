package com.university.university_management_system.controller;


import com.university.university_management_system.model.EnrolledCourseModel;
import com.university.university_management_system.model.ExaminationRoomModel;
import com.university.university_management_system.repository.ExaminationRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExaminationRoomController {
    @Autowired
    ExaminationRoomRepository examinationRoomRepository;

    public List<ExaminationRoomModel> getAllExaminationRooms(){
        return examinationRoomRepository.findAll();
    }

    public ExaminationRoomModel getExaminationRoomByID(Integer id){
        return examinationRoomRepository.findById(id).orElseThrow();
    }
}
