package com.sms.schoolmanagementsystem.model.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Data
public class AddStudentDTO {

    @NotBlank(message = "Student firstName can not be empty")
    private String firstName;

    @NotBlank(message = "Student lastName can not be empty")
    private String lastName;

    private Date dateOfBirth;

    @NotBlank(message = "Student address can not be empty")
    private String address;

    @NotBlank(message = "Student contactNumber can not be empty")
    @Pattern(regexp = "\\+?\\d{10,15}", message = "Contact number must be a string of 10 to 15 digits")
    @Size(min = 10, max = 15, message = "Contact number length must be between 10 and 15 characters")
    private String contactNumber;

    @NotBlank(message = "Student email can not be empty")
    @Email(message = "Student email should be a valid email")
    private String email;

    private String referenceNumber;

    @NotNull(message = "Student level can not be empty")
    @Positive(message = "Student level value must be a positive number")
    private Long level;



    @NotEmpty(message = "Student courseIds can not be empty")
    @NotNull(message = "Student courseIds can not be null")
    private List<UUID> courseIds;


}

