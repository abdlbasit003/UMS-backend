package com.university.university_management_system.DTOs;




import com.university.university_management_system.model.DepartmentModel;

import java.util.HashMap;
import java.util.Map;

    public class DepartmentDTO {

        private int departmentId;
        private String departmentName;
        private Map<String, Object> departmentHead;

        // Constructors
        public DepartmentDTO() {
            this.departmentHead = new HashMap<>();
        }

        public DepartmentDTO(int departmentId, String departmentName, Map<String,Object> departmentHead) {
            this.departmentId = departmentId;
            this.departmentName = departmentName;
            this.departmentHead = departmentHead;
        }

        // Getters and Setters
        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public Map<String, Object> getDepartmentHead() {
            return departmentHead;
        }

        public void setDepartmentHead(Map<String, Object> departmentHead) {
            this.departmentHead = departmentHead;
        }

        // Static fromModel method
        @SuppressWarnings("unchecked")
        public static DepartmentDTO fromModel(DepartmentModel departmentModel) {
         /*   DepartmentDTO dto = new DepartmentDTO();
            dto.setDepartmentId((Integer) model.get("departmentId"));
            dto.setDepartmentName((String) model.get("departmentName"));

            Object headObj = model.get("departmentHead");
            if (headObj instanceof Map) {
                dto.setDepartmentHead((Map<String, String>) headObj);
            } else {
                dto.setDepartmentHead(new HashMap<>()); // Set to empty map if invalid
            }
*/

            Map<String,Object> departmentHead  = new HashMap<>();
            departmentHead.put("id" , departmentModel.getDepartmentHead().getUser().getUuid());
            departmentHead.put("name" , departmentModel.getDepartmentHead().getUser().getUserName());


            return new DepartmentDTO(departmentModel.getDepartmentId(), departmentModel.getDepartmentName(),departmentHead);
        }

    }


