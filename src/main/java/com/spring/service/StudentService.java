package com.spring.service;

import com.spring.dto.StudentRequest;
import com.spring.model.Student;

import java.util.List;

public interface StudentService
{
    String saveStudent(StudentRequest student);

    List<Student> getAllStudent();
}
