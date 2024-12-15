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
        List<InvigilatorDTO> invigilators = new ArrayList<>();
        for (InvigilatorModel model : invigilatorRepository.findAll()) {
            invigilators.add(InvigilatorDTO.fromModel(model));
        }
        return invigilators;
    }

    public InvigilatorDTO getInvigilatorById(int invigilatorId) {
        InvigilatorModel model = invigilatorRepository.findById(invigilatorId).orElse(null);
        if (model == null) {
            throw new RuntimeException("INvigilator not found with the ID: " + invigilatorId);
        }
        return InvigilatorDTO.fromModel(model);
    }

    public List<InvigilatorDTO> getInvigilatorsByFacultyId(int facultyId) {
        List<InvigilatorDTO> invigilators = new ArrayList<>();
        for (InvigilatorModel model : invigilatorRepository.findAll()) {
            if (model.getFaculty().getFacultyId() == facultyId) {
                invigilators.add(InvigilatorDTO.fromModel(model));
            }
        }
        return invigilators;
    }

    public List<InvigilatorDTO> getInvigilatorsByExamHallId(int examHallId) {
        List<InvigilatorDTO> invigilators = new ArrayList<>();

        for (InvigilatorModel model : invigilatorRepository.findAll()) {
            if (model.getExamHall().getExamHallId() == examHallId) {
                invigilators.add(InvigilatorDTO.fromModel(model));
            }
        }
        return invigilators;
    }
}