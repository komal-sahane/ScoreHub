package com.spring.controller;

import com.spring.model.Department;
import com.spring.model.Subject;
import com.spring.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController
{
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public ResponseEntity<String> addDepartment(@RequestBody Department department)
    {
        for (Subject subject : department.getSubject()) {
            subject.setDepartment(department);
        }
        departmentService.addDepartment(department);
        return new ResponseEntity<>("Department Saved", HttpStatus.CREATED);
    }
    @GetMapping("/show")
    public ResponseEntity<List<Department>> getDepartment()
    {
        List<Department> departmentList = departmentService.getDepartment();
        return new ResponseEntity<>(departmentList, HttpStatus.OK);
    }
}
