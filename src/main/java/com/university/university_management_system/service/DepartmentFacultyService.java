package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.DepartmentDTO;
import com.university.university_management_system.DTOs.DepartmentFacultyDTO;
import com.university.university_management_system.model.DepartmentFacultyModel;
import com.university.university_management_system.repository.DepartmentFacultyRepository;
import com.university.university_management_system.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentFacultyService {

    @Autowired
    private DepartmentFacultyRepository departmentFacultyRepository;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private FacultyService facultyService; 

    public List<DepartmentFacultyDTO> getAll() {
        List<DepartmentFacultyModel> departmentFacultyModels = departmentFacultyRepository.findAll();
        return departmentFacultyModels.stream()
                .map(DepartmentFacultyDTO::fromModel)
                .collect(Collectors.toList());
    }

    public DepartmentFacultyDTO getByDepartmentFacultyId(int departmentFacultyId) {
        return DepartmentFacultyDTO.fromModel(departmentFacultyRepository.findById(departmentFacultyId).orElseThrow(()->new ApiException("Department Faculty not found with ID: " + departmentFacultyId, HttpStatus.NOT_FOUND)));

    }

    public List<DepartmentFacultyDTO> getByDepartmentId(int departmentId) {
        departmentService.getDepartmentById(departmentId); // This will throw an exception if the department does not exist
        return departmentFacultyRepository.findAll()
                .stream().filter(dfm->dfm.getDepartment().getDepartmentId()==departmentId)
                .map(DepartmentFacultyDTO::fromModel)
                .toList();

    }

    public List<DepartmentFacultyDTO> getByFacultyId(int facultyId) {
        facultyService.getFacultyById(facultyId);
        return departmentFacultyRepository.findAll()
                .stream().filter(dfm->dfm.getFaculty().getFacultyId()==facultyId)
                .map(DepartmentFacultyDTO::fromModel)
                .toList();
    }
}