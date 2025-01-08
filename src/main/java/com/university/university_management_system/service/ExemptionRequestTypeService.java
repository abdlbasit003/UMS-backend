package com.university.university_management_system.service;

import com.university.university_management_system.exceptions.ApiException;
import com.university.university_management_system.model.ExemptionRequestTypeModel;
import com.university.university_management_system.repository.ExemptionRequestTypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerTypePredicate;

import java.util.List;
import java.util.Optional;

public class ExemptionRequestTypeService {

    private ExemptionRequestTypeRepository repository;

    public ExemptionRequestTypeService(ExemptionRequestTypeRepository repository) {
        this.repository = repository;
    }

    public List<ExemptionRequestTypeModel> getAllRequestTypes() {
        return repository.findAll();
    }

    public ExemptionRequestTypeModel getRequestTypeById(int id) {
        return repository.findById(id).orElseThrow(()->new ApiException("Exemption request type with ID " + id + " can't be found.", HttpStatus.NOT_FOUND));
    }
}
