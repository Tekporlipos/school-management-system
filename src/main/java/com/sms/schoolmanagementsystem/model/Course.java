package com.sms.schoolmanagementsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @NotEmpty
    @Column(unique = true)
    private String name;

    @NotBlank
    @Column(unique = true)
    private String code;

    private String description;

    @NotNull
    private Integer creditHours;

    private String department;

    private String instructor;

    @NotNull
    private Integer maxCapacity;


    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Students> students;

    @Column( columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
