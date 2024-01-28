package com.sms.schoolmanagementsystem.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class CourseDTO extends AddCourseDTO{

    private UUID id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<UUID> studentIds;

}