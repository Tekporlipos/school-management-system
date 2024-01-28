package com.sms.schoolmanagementsystem.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class StudentDTO extends  AddStudentDTO{

    private UUID id;


    private List<CourseDTO> courses;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}

