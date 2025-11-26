package com.spring.serviceImpl;

import com.spring.model.Department;
import com.spring.repository.DepartmentRepository;
import com.spring.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public String addDepartment(Department department)
    {
        Department saveDepartment =departmentRepository.save(department);
        return "Department Saved";

    }

    @Override
    public List<Department> getDepartment()
    {
        List<Department> departmentList = departmentRepository.findAll();
        return departmentList;
    }
}
