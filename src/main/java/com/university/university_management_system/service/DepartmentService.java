package com.university.university_management_system.service;

import com.university.university_management_system.DTOs.DepartmentDTO;
import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.DepartmentModel;
import com.university.university_management_system.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Retrieve all departments
    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentModel> departments = departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOs = new ArrayList<>();

        for (DepartmentModel department : departments) {
            departmentDTOs.add(convertToDTO(department));
        }

        return departmentDTOs;
    }

    // Retrieve a department by ID
    public DepartmentDTO getDepartmentById(int departmentId) {
        DepartmentModel department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ApiException("Department not found", HttpStatus.NOT_FOUND));
        return convertToDTO(department);
    }

    // Retrieve departments by department head ID
    public List<DepartmentDTO> getDepartmentsByDepartmentHeadId(int headId) {
        List<DepartmentModel> departments = departmentRepository.findAll();
        List<DepartmentDTO> result = new ArrayList<>();

        for (DepartmentModel department : departments) {
            if (department.getDepartmentHead() != null && department.getDepartmentHead().getFacultyId() == headId) {
                result.add(convertToDTO(department));
            }
        }

        if (result.isEmpty()) {
            throw new ApiException("No departments found for the given head ID", HttpStatus.NOT_FOUND);
        }

        return result;
    }

    // Retrieve a department by department name
    public DepartmentDTO getDepartmentByDepartmentName(String departmentName) {
        List<DepartmentModel> departments = departmentRepository.findAll();

        for (DepartmentModel department : departments) {
            if (department.getDepartmentName().equalsIgnoreCase(departmentName)) {
                return convertToDTO(department);
            }
        }

        throw new ApiException("Department not found", HttpStatus.NOT_FOUND);
    }

    // Helper method to convert DepartmentModel to DepartmentDTO
    private DepartmentDTO convertToDTO(DepartmentModel department) {
        return new DepartmentDTO(
                department.getDepartmentId(),
                department.getDepartmentName(),
                department.getDepartmentHead() != null
                        ? Map.of(
                        "id", String.valueOf(department.getDepartmentHead().getFacultyId()),
                        "name", department.getDepartmentHead().getFacultyName()
                )
                        : Map.of() // Empty map if no department head
        );
    }
}
