package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.DepartmentDTO;
import com.university.university_management_system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag (name = "Department", description = "Department endpoints" )

@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("")
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{departmentId}")
    public DepartmentDTO getDepartmentById(@PathVariable int departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }


}
