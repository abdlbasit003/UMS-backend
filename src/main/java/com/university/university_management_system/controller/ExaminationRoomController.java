package com.university.university_management_system.controller;


import com.university.university_management_system.model.EnrolledCourseModel;
import com.university.university_management_system.model.ExaminationRoomModel;
import com.university.university_management_system.repository.ExaminationRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/examrooms")
public class ExaminationRoomController {
    @Autowired
    ExaminationRoomRepository examinationRoomRepository;

    @GetMapping("")
    public List<ExaminationRoomModel> getAllExaminationRooms(){
        return examinationRoomRepository.findAll();
    }

    @GetMapping("/{examRoomId}")
    public ExaminationRoomModel getExaminationRoomByID(@PathVariable Integer examRoomId){
        return examinationRoomRepository.findById(examRoomId).orElseThrow();
    }
}
