package com.university.university_management_system.controller;
import java.util.*;

import com.university.university_management_system.model.FacultyModel;
import com.university.university_management_system.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class facultycontroller {
    @Autowired
    FacultyRepository facultyRepository;

    public List<FacultyModel> getall(){
        return facultyRepository.findAll();
    }
    public FacultyModel getbyid(int id){
        return facultyRepository.findById(id).orElseThrow();
    }
}
