package com.spring.dto;

import com.spring.model.Department;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DepartmentRequest
{
    private int departmentid;
    private String departmentname;
    private Department.Semester semester;
}
