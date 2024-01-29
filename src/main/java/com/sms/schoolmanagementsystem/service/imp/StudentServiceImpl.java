package com.sms.schoolmanagementsystem.service.imp;

import com.sms.schoolmanagementsystem.model.dto.AddStudentDTO;
import com.sms.schoolmanagementsystem.model.dto.StudentDTO;
import com.sms.schoolmanagementsystem.service.CommonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentServiceImpl implements CommonService<StudentDTO, AddStudentDTO> {

    @Override
    public StudentDTO addEntity(AddStudentDTO dto) {
        return null;
    }

    @Override
    public Page<StudentDTO> getAllEntities(Pageable pageable) {
        return null;
    }

    @Override
    public StudentDTO getEntityById(UUID id) {
        return null;
    }
}
