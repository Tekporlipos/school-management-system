package com.sms.schoolmanagementsystem.controller;

import com.sms.schoolmanagementsystem.config.ResponseBody;
import com.sms.schoolmanagementsystem.model.dto.course.AddCourseDTO;
import com.sms.schoolmanagementsystem.model.dto.course.CourseDTO;
import com.sms.schoolmanagementsystem.service.imp.CourseServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseServiceImpl courseService;

    @PostMapping
    public ResponseEntity<ResponseBody<CourseDTO>> addCourse(@Valid @RequestBody AddCourseDTO course) {
        ResponseBody<CourseDTO> courseDTOResponseBody = new ResponseBody<>(courseService.addEntity(course));
        courseDTOResponseBody.setStatus(HttpStatus.CREATED.value());
        courseDTOResponseBody.setMessage("Course added successfully");
        return new ResponseEntity<>(courseDTOResponseBody, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<CourseDTO>> getAllCourses(Pageable pageable) {
        return ResponseEntity.ok(courseService.getAllEntities(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody<CourseDTO>> getCourseById(@PathVariable UUID id) {
        ResponseBody<CourseDTO> courseDTOResponseBody = new ResponseBody<>(courseService.getEntityById(id));
        courseDTOResponseBody.setStatus(HttpStatus.CREATED.value());
        courseDTOResponseBody.setMessage("Course data retried successfully");
        return new ResponseEntity<>(courseDTOResponseBody, HttpStatus.CREATED);
    }
}
