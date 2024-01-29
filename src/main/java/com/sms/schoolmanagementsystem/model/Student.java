package com.sms.schoolmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private Date dateOfBirth;

    @NotBlank
    private String address;

    @NotBlank
    private String contactNumber;

    @Column(unique = true)
    @NotBlank
    @Email
    private String email;

    @Column(unique = true)
    private String referenceNumber;

    @NotNull
    private Long level;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "STUDENT_COURSE_TABLE",
            joinColumns = {
                    @JoinColumn(name = "student_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "course_id", referencedColumnName = "id")
            }
    )
    @JsonBackReference
    private Set<Course> courses = new HashSet<>();

    @Column( columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
