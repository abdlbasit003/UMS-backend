package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.InvigilatorDTO;
import com.university.university_management_system.service.InvigilatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invigilators")
public class InvigilatorController {

    @Autowired
    private InvigilatorService invigilatorService;

    @GetMapping("")
    public List<InvigilatorDTO> getAllInvigilators() {
        return invigilatorService.getAllInvigilators();
    }

    public InvigilatorDTO getInvigilatorById(int invigilatorId) {
        return invigilatorService.getInvigilatorById(invigilatorId);
    }

    public List<InvigilatorDTO> getInvigilatorsByFacultyId(int facultyId) {
        return invigilatorService.getInvigilatorsByFacultyId(facultyId);
    }

    public List<InvigilatorDTO> getInvigilatorsByExamHallId(int examHallId) {
        return invigilatorService.getInvigilatorsByExamHallId(examHallId);
    }
}
