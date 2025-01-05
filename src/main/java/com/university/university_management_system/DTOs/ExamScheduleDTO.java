package com.university.university_management_system.DTOs;

import com.university.university_management_system.model.ExamModel;
import com.university.university_management_system.model.ExamScheduleModel;
import com.university.university_management_system.model.ExaminationRoomModel;

import java.time.LocalDate;
import java.time.LocalTime;

public class ExamScheduleDTO {
    private int scheduleId;
    private ExamDTO exam;
    private ExaminationRoomDTO examinationRoom;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate examDate;

    public ExamScheduleDTO(int scheduleId, ExamDTO exam, ExaminationRoomDTO examinationRoom, LocalTime startTime, LocalTime endTime, LocalDate examDate) {
        this.scheduleId = scheduleId;
        this.exam = exam;
        this.examinationRoom = examinationRoom;
        this.startTime = startTime;
        this.endTime = endTime;
        this.examDate = examDate;
    }

    // Getters and Setters
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public ExamDTO getExam() {
        return exam;
    }

    public void setExam(ExamDTO exam) {
        this.exam = exam;
    }

    public ExaminationRoomDTO getExaminationRoom() {
        return examinationRoom;
    }

    public void setExaminationRoom(ExaminationRoomDTO examinationRoom) {
        this.examinationRoom = examinationRoom;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }


    public static ExamScheduleDTO fromModel(ExamScheduleModel examScheduleModel) {

        return new ExamScheduleDTO(examScheduleModel.getScheduleId(),
                ExamDTO.fromModel(examScheduleModel.getExam()),
                ExaminationRoomDTO.fromModel(examScheduleModel.getExaminationRoom()),
                 examScheduleModel.getStartTime()
                ,examScheduleModel.getEndTime(),examScheduleModel.getExamDate());
    }
}
