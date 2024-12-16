package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.FacultyDTO;
import com.university.university_management_system.model.FacultyModel;
import com.university.university_management_system.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;


    public List<FacultyDTO> getAllFaculty() {
        List<FacultyModel> facultyList = facultyRepository.getAllFaculty();
        List<FacultyDTO> facultyDTOS = new ArrayList<>();
        for (FacultyModel fm : facultyList){
            facultyDTOS.add(FacultyDTO.fromModel(fm));
        }
       return facultyDTOS;
    }


    public FacultyDTO getFacultyById(int facultyId) {
        FacultyModel faculty = facultyRepository.findById(facultyId)
                .orElseThrow(() -> new RuntimeException("Faculty not found with ID: " + facultyId));
        return FacultyDTO.fromModel(faculty);
    }


    public List<FacultyDTO> getFacultyByName(String facultyName) {
        List<FacultyModel> facultyList = facultyRepository.FindByFacultyName(facultyName);
        List<FacultyDTO> facultyDTOS = new ArrayList<>();
        for (FacultyModel fm : facultyList){
            facultyDTOS.add(FacultyDTO.fromModel(fm));
        }
        return facultyDTOS;

    }


    public List<FacultyDTO> getFacultyByDesignation(String designationName) {
        List<FacultyModel> facultyList = facultyRepository.findByDesignation_DesignationName(designationName);
        List<FacultyDTO> facultyDTOS = new ArrayList<>();
        for (FacultyModel fm : facultyList){
            facultyDTOS.add(FacultyDTO.fromModel(fm));
        }
        return facultyDTOS;
    }


    public FacultyDTO getFacultyByUuid(String facultyUuid) {
        FacultyModel faculty = facultyRepository.findByFacultyUuid(facultyUuid);
        if (faculty == null) {
            throw new RuntimeException("Faculty not found with UUID: " + facultyUuid);
        }
        return FacultyDTO.fromModel(faculty);
    }
}
