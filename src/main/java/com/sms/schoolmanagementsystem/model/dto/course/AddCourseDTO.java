package com.sms.schoolmanagementsystem.model.dto.course;
import com.sms.schoolmanagementsystem.model.dto.student.StudentDataDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Data
public class AddCourseDTO extends CourseDataDTO{

    private Set<StudentDataDTO> students;

}