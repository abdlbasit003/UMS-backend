package com.university.university_management_system.controller;

import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.ExamContentTypeModel;
import com.university.university_management_system.model.ExemptionRequestTypeModel;
import com.university.university_management_system.repository.ExamContentTypeRepository;
import com.university.university_management_system.service.ExemptionRequestTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/examcontentttypes")
@Tag(name = "Exam Content Types")
public class ExamContentTypeController {

    @Autowired
    ExamContentTypeRepository examContentTypeRepository;
    @GetMapping("")
    public List<ExamContentTypeModel> getcontentTypes() {
        return examContentTypeRepository.findAll();
    }
    @GetMapping("/{id}")
    public ExamContentTypeModel getContentTypeById(int id) {
        return examContentTypeRepository.findById(id).orElseThrow();

    }



}





