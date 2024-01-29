package com.sms.schoolmanagementsystem.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CommonService<T, U> {
    T addEntity(U dto);
    Page<T> getAllEntities(Pageable pageable);
    T getEntityById(UUID id);
}
