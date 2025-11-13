package com.spring.controller;

import com.spring.dto.StudentRequest;
import com.spring.model.Student;
import com.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody StudentRequest studentdto)
    {
      studentService.saveStudent(studentdto);
        return new ResponseEntity<>("Student Saved", HttpStatus.CREATED);
    }

    @GetMapping("/show")
    public  ResponseEntity<List<Student>> getAllData()
    {
        List<Student> studentList = studentService.getAllStudent();
        return new ResponseEntity<>(studentList, HttpStatus.OK);

    }
}
