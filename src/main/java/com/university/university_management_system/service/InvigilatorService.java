package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.InvigilatorDTO;
import com.university.university_management_system.model.InvigilatorModel;
import com.university.university_management_system.repository.InvigilatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvigilatorService {

    @Autowired
    private InvigilatorRepository invigilatorRepository;

    public List<InvigilatorDTO> getAllInvigilators() {
        return invigilatorRepository.findAll().stream()
                .map(InvigilatorDTO::fromModel)
                .toList();
    }

    public InvigilatorDTO getInvigilatorById(int invigilatorId) {
        InvigilatorModel model = invigilatorRepository.findById(invigilatorId)
                .orElseThrow(() -> new RuntimeException("Invigilator not found with the ID: " + invigilatorId));
        return InvigilatorDTO.fromModel(model);
    }

    public List<InvigilatorDTO> getInvigilatorsByFacultyId(int facultyId) {
        return invigilatorRepository.findAll().stream()
                .filter(model -> model.getFaculty().getFacultyId() == facultyId)
                .map(InvigilatorDTO::fromModel)
                .toList();
    }

    public List<InvigilatorDTO> getInvigilatorsByExamHallId(int examHallId) {
        return invigilatorRepository.findAll().stream()
                .filter(model -> model.getExamHall().getExamHallId() == examHallId)
                .map(InvigilatorDTO::fromModel)
                .toList();
    }

}