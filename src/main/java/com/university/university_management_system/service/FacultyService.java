package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.FacultyDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.FacultyModel;
import com.university.university_management_system.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;


    public List<FacultyDTO> getAllFaculty() {
        List<FacultyModel> facultyList = facultyRepository.getAllFaculty();
        if (facultyList.isEmpty()) {
            throw new ApiException("No faculty members found", HttpStatus.NOT_FOUND);
        }
        return facultyList.stream()
                .map(FacultyDTO::fromModel)
                .toList();
    }

    public FacultyDTO getFacultyById(int facultyId) {
        FacultyModel faculty = facultyRepository.findById(facultyId)
                .orElseThrow(() -> new ApiException("Faculty not found with ID: " + facultyId, HttpStatus.NOT_FOUND));
        return FacultyDTO.fromModel(faculty);
    }

    public List<FacultyDTO> getFacultyByName(String facultyName) {
        List<FacultyModel> facultyList = facultyRepository.getAllFaculty();
        if (facultyList.isEmpty()) {
            throw new ApiException("No faculty members found", HttpStatus.NOT_FOUND);
        }
        List<FacultyDTO> facultyDTOS = facultyList.stream()
                .filter(fm -> fm.getFacultyName().equalsIgnoreCase(facultyName))
                .map(FacultyDTO::fromModel)
                .toList();
        if (facultyDTOS.isEmpty()) {
            throw new ApiException("No faculty members found with the name: " + facultyName, HttpStatus.NOT_FOUND);
        }
        return facultyDTOS;
    }

    public List<FacultyDTO> getFacultyByDesignation(int designationId) {
        List<FacultyModel> facultyList = facultyRepository.getAllFaculty();
        if (facultyList.isEmpty()) {
            throw new ApiException("No faculty members found", HttpStatus.NOT_FOUND);
        }
        List<FacultyDTO> facultyDTOS = facultyList.stream()
                .filter(fm -> fm.getDesignation().getDesignationId() == designationId)
                .map(FacultyDTO::fromModel)
                .toList();
        if (facultyDTOS.isEmpty()) {
            throw new ApiException("No faculty members found with this designation", HttpStatus.NOT_FOUND);
        }
        return facultyDTOS;
    }

    public FacultyDTO getFacultyByUuid(String facultyUuid) {
        List<FacultyModel> facultyList = facultyRepository.getAllFaculty();
        if (facultyList.isEmpty()) {
            throw new ApiException("No faculty members found", HttpStatus.NOT_FOUND);
        }
        return facultyList.stream()
                .filter(fm -> fm.getUser().getUuid().equals(facultyUuid))
                .findFirst()
                .map(FacultyDTO::fromModel)
                .orElseThrow(() -> new ApiException("Faculty not found with UUID: " + facultyUuid, HttpStatus.NOT_FOUND));
    }

}

