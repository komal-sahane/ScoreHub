package com.spring.controller;

import com.spring.model.Student;
import com.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController
{
    @Autowired
    private StudentService studentService;

    public ResponseEntity<String> addStudent(@RequestBody Student student)
    {

        studentService.saveStudent(student);
        return new ResponseEntity<>("Student Saved", HttpStatus.CREATED);
    }
}
