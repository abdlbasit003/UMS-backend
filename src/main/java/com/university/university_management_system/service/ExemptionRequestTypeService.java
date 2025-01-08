package com.university.university_management_system.service;

import com.university.university_management_system.model.ExemptionRequestTypeModel;
import com.university.university_management_system.repository.ExemptionRequestTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ExemptionRequestTypeService {

    private ExemptionRequestTypeRepository repository;

    public ExemptionRequestTypeService(ExemptionRequestTypeRepository repository) {
        this.repository = repository;
    }

    public List<ExemptionRequestTypeModel> getAllRequestTypes() {
        return repository.findAll();
    }

    public ExemptionRequestTypeModel getRequestTypeById(int id) {
        Optional<ExemptionRequestTypeModel> requestType = repository.findById(id);

        if (requestType.isPresent()) {
            return requestType.get();
        }else{
            throw new RuntimeException("Exemption request type with ID " + id + " can't be found.");
        }
    }
}
