package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.DepartmentFacultyDTO;
import com.university.university_management_system.model.DepartmentFacultyModel;
import com.university.university_management_system.repository.DepartmentFacultyRepository;
import com.university.university_management_system.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
        Optional<DepartmentFacultyModel> departmentFacultyModel = departmentFacultyRepository.findById(departmentFacultyId);
        if (departmentFacultyModel.isPresent()) {
            return DepartmentFacultyDTO.fromModel(departmentFacultyModel.get());
        } else {
            throw new ApiException("Department Faculty not found with ID: " + departmentFacultyId, HttpStatus.NOT_FOUND);
        }
    }

    public List<DepartmentFacultyDTO> getByDepartmentId(int departmentId) {

        try {
            departmentService.getDepartmentById(departmentId); // This will throw an exception if the department does not exist
        } catch (ApiException e) {
            throw new ApiException("Department not found with ID: " + departmentId, HttpStatus.NOT_FOUND);
        }

        List<DepartmentFacultyModel> departmentFacultyModels = departmentFacultyRepository.findByDepartmentId(departmentId);
        if (departmentFacultyModels.isEmpty()) {
            throw new ApiException("No Department Faculty found for Department ID: " + departmentId, HttpStatus.NOT_FOUND);
        }

        return departmentFacultyModels.stream()
                .map(DepartmentFacultyDTO::fromModel)
                .collect(Collectors.toList());
    }

    public List<DepartmentFacultyDTO> getByFacultyId(int facultyId) {

        try {
            facultyService.getFacultyById(facultyId);
        } catch (ApiException e) {
            throw new ApiException("Faculty not found with ID: " + facultyId, HttpStatus.NOT_FOUND);
        }


        List<DepartmentFacultyModel> departmentFacultyModels = departmentFacultyRepository.findByFacultyId(facultyId);
        if (departmentFacultyModels.isEmpty()) {
            throw new ApiException("No Department Faculty found for Faculty ID: " + facultyId, HttpStatus.NOT_FOUND);
        }

        return departmentFacultyModels.stream()
                .map(DepartmentFacultyDTO::fromModel)
                .collect(Collectors.toList());
    }
}