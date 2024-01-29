# School Management System

## Overview
This is a School Management System developed using Spring Boot. The system allows the management of courses and students, maintaining relationships where a student can enroll in multiple courses, and a course can be taken by multiple students.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
    - [Installation](#installation)
    - [Configuration](#configuration)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Logging](#logging)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites
Before you begin, ensure you have met the following requirements:
- Java Development Kit (JDK) installed
- Maven installed
- PostgreSQL (or H2 for development) installed

## Getting Started

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Tekporlipos/school-management-system.git
   cd school-management-system

Build the project using Maven:

``` bash 
mvn clean install
```

Configuration

Update the application.properties file with your database configuration:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```
Usage

Run the application:

```bash
    java -jar target/school-management-system.jar
```

Open a web browser and visit http://localhost:8080/api/v1/swagger-ui.html for API documentation.

Endpoints

Course Endpoints

       Add Course
        Endpoint: POST /courses
        Description: Add a new course.
        Request Body: AddCourseDTO
        Response Body: ResponseBody<CourseDTO>
        Status Codes:
            201 Created - Course added successfully
            400 Bad Request - Invalid input

    Get All Courses
        Endpoint: GET /courses
        Description: Retrieve a paginated list of all courses.
        Request Parameters: Pageable parameters (optional)
        Response Body: Page<CourseDTO>
        Status Codes:
            200 OK - Courses retrieved successfully
            400 Bad Request - Invalid input

    Get Course by ID
        Endpoint: GET /courses/{id}
        Description: Retrieve details of a specific course by ID.
        Path Variable: id - UUID of the course
        Response Body: ResponseBody<CourseDTO>
        Status Codes:
            200 OK - Course data retrieved successfully
            404 Not Found - Course not found

Student Endpoints

    Add Student
        Endpoint: POST /students
        Description: Add a new student.
        Request Body: AddStudentDTO
        Response Body: ResponseBody<StudentDTO>
        Status Codes:
            201 Created - Student added successfully
            400 Bad Request - Invalid input

    Get All Students
        Endpoint: GET /students
        Description: Retrieve a paginated list of all students.
        Request Parameters: Pageable parameters (optional)
        Response Body: Page<StudentDTO>
        Status Codes:
            200 OK - Students retrieved successfully
            400 Bad Request - Invalid input

    Get Student by ID
        Endpoint: GET /students/{id}
        Description: Retrieve details of a specific student by ID.
        Path Variable: id - UUID of the student
        Response Body: ResponseBody<StudentDTO>
        Status Codes:
            200 OK - Student data retrieved successfully
            404 Not Found - Student not found

Logging

Logging properties are configured in the application.properties file. Logs are stored in the storage/logs directory.

Contributing

    Fork the project.
    Create a new branch (git checkout -b feature/your-feature).
    Commit your changes (git commit -m 'Add your feature').
    Push to the branch (git push origin feature/your-feature).
    Open a Pull Request.

License
This project is licensed under the MIT License.
