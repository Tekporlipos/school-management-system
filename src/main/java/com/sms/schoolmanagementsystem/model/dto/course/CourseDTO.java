package com.sms.schoolmanagementsystem.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sms.schoolmanagementsystem.model.Student;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class CourseDTO extends AddCourseDTO{

    private UUID id;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    @JsonIgnore
    private List<UUID> studentIds;

    private List<AddStudentDTO> students;

}