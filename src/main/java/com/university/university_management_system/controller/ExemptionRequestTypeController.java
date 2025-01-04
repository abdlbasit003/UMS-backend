package com.university.university_management_system.controller;

import com.university.university_management_system.model.ExemptionRequestTypeModel;
import com.university.university_management_system.service.ExemptionRequestTypeService;

import java.util.List;
public class ExemptionRequestTypeController {

    private final ExemptionRequestTypeService service;

    public ExemptionRequestTypeController(ExemptionRequestTypeService service) {
        this.service = service;
    }

    public List<ExemptionRequestTypeModel> getAllRequestTypes() {
        return service.getAllRequestTypes();
    }

    public ExemptionRequestTypeModel getRequestTypeById(int id) {
        return service.getRequestTypeById(id);
    }
}
