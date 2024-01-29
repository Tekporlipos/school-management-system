package com.sms.schoolmanagementsystem.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddCourseDTO {

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