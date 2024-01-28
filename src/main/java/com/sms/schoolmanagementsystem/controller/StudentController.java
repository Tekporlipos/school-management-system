package com.sms.schoolmanagementsystem.controller;

import com.sms.schoolmanagementsystem.model.Student;
import com.sms.schoolmanagementsystem.model.dto.AddStudentDTO;
import com.sms.schoolmanagementsystem.model.dto.StudentDTO;
import com.sms.schoolmanagementsystem.repository.StudentRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<AddStudentDTO> addStudent(@Valid @RequestBody AddStudentDTO student) {
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable UUID id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
