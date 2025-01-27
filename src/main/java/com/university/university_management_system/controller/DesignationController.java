package com.university.university_management_system.controller;
import java.util.*;

import com.university.university_management_system.model.DesignationModel;
import com.university.university_management_system.repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag (name = "Designation", description = "Designation endpoints" )

@RequestMapping("/designations")
public class DesignationController {

    @Autowired
    DesignationRepository designationRepository;

    @GetMapping("")
    public List<DesignationModel> getall(){
        return designationRepository.findAll();
    }
    @GetMapping("/{designationId}")
    public DesignationModel getbyid(@PathVariable int designationId){
        return designationRepository.findById(designationId).orElseThrow();
    }
}
