package com.university.university_management_system.DTOs;

import com.university.university_management_system.model.ExaminationRoomModel;

public class ExaminationRoomDTO {
    public int examinationRoomId;
    public ExamDTO exam;
    public StudentDTO student;

    public ExaminationRoomDTO(int examinationRoomId, ExamDTO examDTO, StudentDTO studentDTO) {
        this.examinationRoomId = examinationRoomId;
        this.exam = examDTO;
        this.student = studentDTO;
    }

    public int getExaminationRoomId() {
        return examinationRoomId;
    }

    public void setExaminationRoomId(int examinationRoomId) {
        this.examinationRoomId = examinationRoomId;
    }

    public ExamDTO getExam() {
        return exam;
    }

    public void setExam(ExamDTO examDTO) {
        this.exam = examDTO;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO studentDTO) {
        this.student = studentDTO;
    }

    public static ExaminationRoomDTO fromModel(ExaminationRoomModel model) {
        ExamDTO exam = ExamDTO.fromModel(model.getExam());
        StudentDTO student = StudentDTO.fromModel(model.getStudent());
        return new ExaminationRoomDTO(model.getId(), exam, student);
    }
}
