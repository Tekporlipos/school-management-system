package com.sms.schoolmanagementsystem.model.dto.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;


@Data
public class CourseDataDTO {

    private UUID id;

    @NotBlank(message = "Course name can not be empty")
    private String name;

    @NotBlank(message = "Course code can not be empty")
    private String code;

    private String description;

    @NotNull(message = "Course creditHours can not be empty")
    private Integer creditHours;

    private String department;

    private String instructor;

    @NotNull(message = "Course maxCapacity can not be empty")
    private Integer maxCapacity;

}