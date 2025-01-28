package com.university.university_management_system.controller;

import com.university.university_management_system.model.ExemptionRequestTypeModel;
import com.university.university_management_system.service.ExemptionRequestTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/exemptionrequesttypes")
public class ExemptionRequestTypeController {

    ExemptionRequestTypeService service;
    @GetMapping("")
    public List<ExemptionRequestTypeModel> getAllRequestTypes() {
        return service.getAllRequestTypes();
    }
    @GetMapping("/{id}")
    public ExemptionRequestTypeModel getRequestTypeById(int id) {
        return service.getRequestTypeById(id);
    }
}
