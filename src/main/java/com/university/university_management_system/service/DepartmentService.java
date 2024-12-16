package com.university.university_management_system.service;
import com.university.university_management_system.DTOs.DepartmentDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentService {


    // Simulate a database or data source
    private static List<DepartmentDTO> departments = new ArrayList<>();

    // Static initializer to populate the department list
    static {
        // Create some sample department data
        departments.add(new DepartmentDTO(1, "Computer Science", new HashMap<>() {{
            put("id","f101");
            put("name", "John Doe");
        }}));
        departments.add(new DepartmentDTO(2, "Mathematics", new HashMap<>() {{
            put("id", "F102");
            put("name", "Jane Doe");
        }}));
    }

    // Method to retrieve all departments
    public List<DepartmentDTO> getAllDepartments() {
        return departments;
    }

    // Method to retrieve a department by ID
    public DepartmentDTO getDepartmentById(int departmentId) {
        for (DepartmentDTO department : departments) {
            if (department.getDepartmentId() == departmentId) {
                return department;
            }
        }
        return null; // Or throw an exception
    }

    // Method to retrieve departments by department head ID
    public List<DepartmentDTO> getDepartmentsByDepartmentHeadId(int headId) {
        List<DepartmentDTO> result = new ArrayList<>();
        for (DepartmentDTO department : departments) {
            Map<String, Object> head = department.getDepartmentHead();
            if (head != null && head.get("id").equals(headId)) {
                result.add(department);
            }
        }
        return result;
    }

    // Method to retrieve a department by department name
    public DepartmentDTO getDepartmentByDepartmentName(String departmentName) {
        for (DepartmentDTO department : departments) {
            if (department.getDepartmentName().equals(departmentName)) {
                return department;
            }
        }
        return null; // Or throw an exception
    }


}
