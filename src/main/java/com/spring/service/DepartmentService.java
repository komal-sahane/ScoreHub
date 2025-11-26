package com.spring.service;

import com.spring.model.Department;

import java.util.List;

public interface DepartmentService {
    String addDepartment(Department department);

    List<Department> getDepartment();
}
