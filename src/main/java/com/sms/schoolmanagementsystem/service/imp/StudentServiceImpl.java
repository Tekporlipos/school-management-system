package com.sms.schoolmanagementsystem.service.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.schoolmanagementsystem.config.exception.CustomException;
import com.sms.schoolmanagementsystem.model.Student;
import com.sms.schoolmanagementsystem.model.dto.AddStudentDTO;
import com.sms.schoolmanagementsystem.model.dto.StudentDTO;
import com.sms.schoolmanagementsystem.repository.StudentRepository;
import com.sms.schoolmanagementsystem.service.CommonService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements CommonService<StudentDTO, AddStudentDTO> {

    private final ObjectMapper objectMapper;
    private final StudentRepository studentRepository;
    @Override
    public StudentDTO addEntity(AddStudentDTO dto) {
        if (studentRepository.findStudentByEmailOrReferenceNumber(dto.getEmail(),dto.getReferenceNumber()).isPresent()){
            throw new CustomException("Student already exist", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        Student student = objectMapper.convertValue(dto, Student.class);
        return objectMapper.convertValue(studentRepository.save(student), StudentDTO.class);
    }

    @Override
    public Page<StudentDTO> getAllEntities(Pageable pageable) {
        Page<Student> coursePage = studentRepository.findAll(pageable);
        return coursePage.map(course -> objectMapper.convertValue(course, StudentDTO.class));
    }

    @Override
    public StudentDTO getEntityById(UUID id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new CustomException("Student not found", HttpStatus.NOT_FOUND));
        return objectMapper.convertValue(student, StudentDTO.class);
    }
}
