package com.sms.schoolmanagementsystem.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class StudentDTO extends  AddStudentDTO{

    private UUID id;

    @JsonIgnore
    private List<UUID> courseIds;

    private List<CourseDTO> courses;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}

