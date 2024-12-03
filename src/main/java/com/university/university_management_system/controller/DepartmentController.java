package com.university.university_management_system.controller;

import com.university.university_management_system.model.DepartmentModel;
import com.university.university_management_system.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;


    public List<DepartmentModel> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public DepartmentModel getDepartmentById(int departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow();
    }
}
