package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.DepartmentFacultyDTO;
import com.university.university_management_system.service.DepartmentFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departmentfaculty")
public class DepartmentFacultyController {

    @Autowired
    private DepartmentFacultyService departmentFacultyService;

    @GetMapping("")
    public List<DepartmentFacultyDTO> getAll() {
        return departmentFacultyService.getAll();
    }

    @GetMapping("/{departmentFacultyId}")
    public DepartmentFacultyDTO getById(@PathVariable int departmentFacultyId) {
        return departmentFacultyService.getByDepartmentFacultyId(departmentFacultyId);
    }

    @GetMapping("/byDepartment/{departmentId}")
    public List<DepartmentFacultyDTO> getByDepartmentId(@PathVariable int departmentId) {
        return departmentFacultyService.getByDepartmentId(departmentId);
    }

    @GetMapping("/byFaculty/{facultyId}")
    public List<DepartmentFacultyDTO> getByFacultyId(@PathVariable int facultyId) {
        return departmentFacultyService.getByFacultyId(facultyId);
    }
}