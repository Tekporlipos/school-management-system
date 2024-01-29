package com.sms.schoolmanagementsystem.model.dto.student;

import com.sms.schoolmanagementsystem.model.dto.course.CourseDataDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class AddStudentDTO extends StudentDataDTO{

    private Set<CourseDataDTO> courses;

}

