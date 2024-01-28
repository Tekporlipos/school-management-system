package com.sms.schoolmanagementsystem.controller;

import com.sms.schoolmanagementsystem.model.dto.AddCourseDTO;
import com.sms.schoolmanagementsystem.model.dto.CourseDTO;
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
    @PostMapping
    public ResponseEntity<AddCourseDTO> addCourse(@Valid @RequestBody AddCourseDTO course) {

        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<CourseDTO>> getAllCourses(Pageable pageable) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable UUID id) {
        return null;
    }
}
