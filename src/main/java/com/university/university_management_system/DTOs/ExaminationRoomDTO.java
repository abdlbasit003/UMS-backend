package com.university.university_management_system.DTOs;

import com.university.university_management_system.model.ExaminationRoomModel;

public class ExaminationRoomDTO {
    public int examinationRoomId;
    public ExamDTO examDTO;
    public StudentDTO studentDTO;

    public ExaminationRoomDTO(int examinationRoomId, ExamDTO examDTO, StudentDTO studentDTO) {
        this.examinationRoomId = examinationRoomId;
        this.examDTO = examDTO;
        this.studentDTO = studentDTO;
    }

    public int getExaminationRoomId() {
        return examinationRoomId;
    }

    public void setExaminationRoomId(int examinationRoomId) {
        this.examinationRoomId = examinationRoomId;
    }

    public ExamDTO getExamDTO() {
        return examDTO;
    }

    public void setExamDTO(ExamDTO examDTO) {
        this.examDTO = examDTO;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public static ExaminationRoomDTO fromModel(ExaminationRoomModel model) {
        ExamDTO examDTO = ExamDTO.fromModel(model.getExam());
        StudentDTO studentDTO = StudentDTO.fromModel(model.getStudent());
        return new ExaminationRoomDTO(model.getId(), examDTO, studentDTO);
    }
}
