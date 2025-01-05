package com.university.university_management_system.DTOs;

import com.university.university_management_system.DTOs.DepartmentDTO;
import com.university.university_management_system.model.DepartmentFacultyModel;

import java.util.HashMap;

public class DepartmentFacultyDTO {
    private int departmentFacultyId;
    private DepartmentDTO departmentDTO;
    private HashMap<String,Object> faculty;

   
    public int getDepartmentFacultyId() {
        return departmentFacultyId;
    }

    public void setDepartmentFacultyId(int departmentFacultyId) {
        this.departmentFacultyId = departmentFacultyId;
    }

    public DepartmentDTO getDepartmentDTO() {
        return departmentDTO;
    }

    public void setDepartmentDTO(DepartmentDTO departmentDTO) {
        this.departmentDTO = departmentDTO;
    }

    public HashMap<String, Object> getFaculty() {
        return faculty;
    }

    public void setFaculty(HashMap<String, Object> faculty) {
        this.faculty = faculty;
    }

    
    public static DepartmentFacultyDTO fromModel(DepartmentFacultyModel dfm) {
        DepartmentFacultyDTO dto = new DepartmentFacultyDTO();
        dto.setDepartmentFacultyId(dfm.getDepartmentFacultyId());

       
        dto.setDepartmentDTO(DepartmentDTO.fromModel(dfm.getDepartment()));

        HashMap<String, Object> facultyMap = new HashMap<>();
        if (dfm.getFaculty() != null) {
            facultyMap.put("facultyId", String.valueOf(dfm.getFaculty().getFacultyId())); // Assuming FacultyModel has getFacultyId()
            facultyMap.put("facultyName", dfm.getFaculty().getFacultyName()); // Assuming FacultyModel has getFacultyName()
        }
        dto.setFaculty(facultyMap);

        return dto;
    }
}