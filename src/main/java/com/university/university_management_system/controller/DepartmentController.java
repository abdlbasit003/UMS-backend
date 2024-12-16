package com.university.university_management_system.controller;

import com.university.university_management_system.DTOs.DepartmentDTO;
import com.university.university_management_system.model.DepartmentModel;
import com.university.university_management_system.repository.DepartmentRepository;
import com.university.university_management_system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;


    @GetMapping("")
    public List<DepartmentDTO> getAllDepartments(){
        return departmentService.getAllDepartments();
    }


    @GetMapping("/{departmentId}")
    public DepartmentDTO getDepartmentById(@PathVariable int departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    public DepartmentDTO getDepartmentByDepartmentName(String departmentname){
        return departmentService.getDepartmentByDepartmentName(departmentname);
    }
    public List<DepartmentDTO>  getDepartmentsByDepartmentHeadId(int headId){
        return departmentService.getDepartmentsByDepartmentHeadId(headId);
    }
}
