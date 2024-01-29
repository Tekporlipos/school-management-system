package com.sms.schoolmanagementsystem.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class StudentDTO extends  AddStudentDTO{

    @JsonIgnore
    private Set<UUID> courseIds;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    private Set<AddCourseDTO> courses;

}

