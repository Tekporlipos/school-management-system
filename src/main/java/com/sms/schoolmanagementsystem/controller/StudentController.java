package com.sms.schoolmanagementsystem.controller;

import com.sms.schoolmanagementsystem.config.ResponseBody;
import com.sms.schoolmanagementsystem.model.dto.student.AddStudentDTO;
import com.sms.schoolmanagementsystem.model.dto.student.StudentDTO;
import com.sms.schoolmanagementsystem.service.imp.StudentServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private final StudentServiceImpl studentService;

    @PostMapping
    public ResponseEntity<ResponseBody<StudentDTO>> addStudent(@Valid @RequestBody AddStudentDTO student) {
        ResponseBody<StudentDTO> studentDTOResponseBody = new ResponseBody<>(studentService.addEntity(student));
        studentDTOResponseBody.setStatus(HttpStatus.CREATED.value());
        studentDTOResponseBody.setMessage("Student added successfully");
        return new ResponseEntity<>(studentDTOResponseBody, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<StudentDTO>> getAllStudents(Pageable pageable) {
        return ResponseEntity.ok(studentService.getAllEntities(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody<StudentDTO>> getStudentById(@PathVariable UUID id) {
        ResponseBody<StudentDTO> studentDTOResponseBody = new ResponseBody<>(studentService.getEntityById(id));
        studentDTOResponseBody.setStatus(HttpStatus.CREATED.value());
        studentDTOResponseBody.setMessage("Course data retried successfully");
        return new ResponseEntity<>(studentDTOResponseBody, HttpStatus.CREATED);
    }
}
