package com.university.university_management_system.controller;
import java.util.*;

import com.university.university_management_system.model.DesignationModel;
import com.university.university_management_system.repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class designationcontroller {
    @Autowired
    DesignationRepository designationRepository;

    public List<DesignationModel> getall(){
        return designationRepository.findAll();
    }
    public DesignationModel getbyid(int id){
        return designationRepository.findById(id).orElseThrow();
    }
}
