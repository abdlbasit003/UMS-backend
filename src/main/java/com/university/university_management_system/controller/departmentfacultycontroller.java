package com.university.university_management_system.controller;
import java.util.*;

import com.university.university_management_system.model.DepartmentFacultyModel;
import com.university.university_management_system.repository.DepartmentFacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class departmentfacultycontroller {
    @Autowired
    DepartmentFacultyRepository departmentFacultyRepository;

    public List<DepartmentFacultyModel> getall(){
        return departmentFacultyRepository.findAll();
    }
    public DepartmentFacultyModel getbyid(int  id){
        return departmentFacultyRepository.findById(id).orElseThrow();
    }
}
