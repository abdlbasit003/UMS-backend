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
        for (FacultyModel fm : facultyList) {
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
        List<FacultyModel> facultyList = facultyRepository.getAllFaculty();
        List<FacultyDTO> facultyDTOS = new ArrayList<>();
        for (FacultyModel fm : facultyList) {
            if (fm.getFacultyName().equalsIgnoreCase(facultyName)) {
                facultyDTOS.add(FacultyDTO.fromModel(fm));
            }
        }
        return facultyDTOS;
    }


    public List<FacultyDTO> getFacultyByDesignation(String designationName) {
        List<FacultyModel> facultyList = facultyRepository.getAllFaculty(); 
        List<FacultyDTO> facultyDTOS = new ArrayList<>();
        for (FacultyModel fm : facultyList) {
            if (fm.getDesignation().getDesignationName().equalsIgnoreCase(designationName)) {
                facultyDTOS.add(FacultyDTO.fromModel(fm));
            }
        }
        return facultyDTOS;


    }
    public FacultyDTO getFacultyByUuid(String facultyUuid) throws Exception {
        List<FacultyModel> facultyList = facultyRepository.getAllFaculty();
        for (FacultyModel fm : facultyList) {
            if (fm.getUser().getUuid().equals(facultyUuid)) {
                return FacultyDTO.fromModel(fm);
            }
        }
        throw new Exception("Faculty not found with UUID: " + facultyUuid);
    }
}

