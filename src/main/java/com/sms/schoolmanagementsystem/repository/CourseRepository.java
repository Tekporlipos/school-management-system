package com.sms.schoolmanagementsystem.repository;

import com.sms.schoolmanagementsystem.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends CrudRepository<Course, UUID>, PagingAndSortingRepository<Course, UUID> {
}
