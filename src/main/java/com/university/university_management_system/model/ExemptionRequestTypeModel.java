package com.university.university_management_system.model;
import jakarta.persistence.*;

@Entity
@Table(name = "request_type")
public class ExemptionRequestTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_type_id")
    private int requestTypeId;

    @Column(name = "request_name", nullable = false)
    private String name;

    @Column(name = "request_description")
    private String description;

    public int getRequestTypeId() {
        return requestTypeId;
    }

    public void setRequestTypeId(int requestTypeId) {
        this.requestTypeId = requestTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
