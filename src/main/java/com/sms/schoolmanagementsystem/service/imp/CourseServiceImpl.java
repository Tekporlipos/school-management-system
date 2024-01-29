package com.sms.schoolmanagementsystem.service.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.schoolmanagementsystem.config.exception.CustomException;
import com.sms.schoolmanagementsystem.model.Course;
import com.sms.schoolmanagementsystem.model.dto.course.AddCourseDTO;
import com.sms.schoolmanagementsystem.model.dto.course.CourseDTO;
import com.sms.schoolmanagementsystem.repository.CourseRepository;
import com.sms.schoolmanagementsystem.service.CommonService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@AllArgsConstructor
public class CourseServiceImpl implements CommonService<CourseDTO, AddCourseDTO> {

    private final CourseRepository courseRepository;
    private final ObjectMapper objectMapper;

    @Override
    @Transactional
    public CourseDTO addEntity(AddCourseDTO dto) {
        if (courseRepository.findCourseByCodeOrName(dto.getCode(),dto.getName()).isPresent()){
            throw new CustomException("Course already exist", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        System.out.println(objectMapper.convertValue(dto, Course.class));
        Course save = courseRepository.save(objectMapper.convertValue(dto, Course.class));
        return objectMapper.convertValue(save, CourseDTO.class);
    }

    @Override
    public Page<CourseDTO> getAllEntities(Pageable pageable) {
        Page<Course> coursesPage = courseRepository.findAll(pageable);
        return coursesPage.map(course -> objectMapper.convertValue(course, CourseDTO.class));
    }

    @Override
    public CourseDTO getEntityById(UUID id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CustomException("Course not found", HttpStatus.NOT_FOUND));
        return objectMapper.convertValue(course, CourseDTO.class);
    }
}
