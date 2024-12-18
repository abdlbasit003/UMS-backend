package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.DepartmentDTO;
import com.university.university_management_system.enums.FacultyDesignation;
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
        List<DepartmentModel> departments = departmentRepository.findAll();
        if (departments.isEmpty()) {
            throw new ApiException("No departments found", HttpStatus.NOT_FOUND);
        }
        List<DepartmentDTO> departmentDTOs = new ArrayList<>();
        for (DepartmentModel department : departments) {
            departmentDTOs.add(DepartmentDTO.fromModel(department));
        }
        return departmentDTOs;
    }

    public DepartmentDTO getDepartmentById(int departmentId) {
        DepartmentModel department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ApiException("Department not found", HttpStatus.NOT_FOUND));
        return DepartmentDTO.fromModel(department);
    }

    public List<DepartmentDTO> getDepartmentsByDepartmentHeadId(int headId) {
        FacultyModel headOfDep = facultyRepository.findById(headId)
                .orElseThrow(() -> new ApiException("Invalid id for the head of Department", HttpStatus.NOT_FOUND));

        if (!headOfDep.getDesignation().getDesignationName().equals(FacultyDesignation.HEAD_OF_DEPARTMENT.getDesignation())) {
            throw new ApiException("Please provide a valid HOD id", HttpStatus.NOT_FOUND);
        }

        List<DepartmentModel> departments = departmentRepository.findAll();
        if (!departments.isEmpty()) {
            List<DepartmentDTO> result = new ArrayList<>();
            for (DepartmentModel department : departments) {
                if (department.getDepartmentHead() != null && department.getDepartmentHead().getFacultyId() == headId) {
                    result.add(DepartmentDTO.fromModel(department));
                }
            }

            if (result.isEmpty()) {
                throw new ApiException("No departments found for the given head ID", HttpStatus.NOT_FOUND);
            }
            return result;
        }

        throw new ApiException("No departments found", HttpStatus.NOT_FOUND);
    }

    public DepartmentDTO getDepartmentByDepartmentName(String departmentName) {
        List<DepartmentModel> departments = departmentRepository.findAll();
        for (DepartmentModel department : departments) {
            if (department.getDepartmentName().equalsIgnoreCase(departmentName)) {
                return DepartmentDTO.fromModel(department);
            }
        }
        throw new ApiException("Department not found", HttpStatus.NOT_FOUND);
    }
}
