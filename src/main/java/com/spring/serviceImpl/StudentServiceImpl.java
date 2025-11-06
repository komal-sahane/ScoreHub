package com.spring.serviceImpl;

import com.spring.model.Student;
import com.spring.repository.StudentRepository;
import com.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String saveStudent(Student student)
    {
        Student savestudent = studentRepository.save(student);
        return "Student Saved";
    }
}
