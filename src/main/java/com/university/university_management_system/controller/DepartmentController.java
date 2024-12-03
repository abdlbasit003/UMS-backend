package com.university.university_management_system.controller;

import com.university.university_management_system.model.DepartmentModel;
import com.university.university_management_system.repository.DepartmentRepository;
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
    DepartmentRepository departmentRepository;


    @GetMapping("")
    public List<DepartmentModel> getAllDepartments(){
        return departmentRepository.findAll();
    }


    @GetMapping("/{departmentId}")
    public DepartmentModel getDepartmentById(@PathVariable int departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow();
    }
}
