package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.DepartmentDTO;
import com.university.university_management_system.DTOs.DepartmentFacultyDTO;
import com.university.university_management_system.utils.Constants;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.DepartmentModel;
import com.university.university_management_system.model.FacultyModel;
import com.university.university_management_system.repository.DepartmentRepository;
import com.university.university_management_system.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll()
                .stream().map(DepartmentDTO::fromModel).toList();
    }

    public DepartmentDTO getDepartmentById(int departmentId) {
        return departmentRepository.findById(departmentId)
                .map(DepartmentDTO::fromModel)
                .orElseThrow(() -> new ApiException("Department not found", HttpStatus.NOT_FOUND));
    }

    public List<DepartmentDTO> getDepartmentsByDepartmentHeadId(int headId) {
        FacultyModel headOfDep = facultyRepository.findById(headId)
                .filter(faculty -> faculty.getDesignation().getDesignationName().equals(Constants.HEAD_OF_DEPARTMENT))
                .orElseThrow(() -> new ApiException("Invalid id for the head of Department or not a valid HOD", HttpStatus.NOT_FOUND));

        List<DepartmentDTO> result = departmentRepository.findAll().stream()
                .filter(department -> department.getDepartmentHead() != null && department.getDepartmentHead().getFacultyId() == headId)
                .map(DepartmentDTO::fromModel)
                .toList();

        if (result.isEmpty()) {
            throw new ApiException("No departments found for the given head ID", HttpStatus.NOT_FOUND);
        }
        return result;
    }

}
