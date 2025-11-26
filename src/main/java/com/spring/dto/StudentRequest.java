package com.spring.dto;

import com.spring.model.Student;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Year;
@Getter
@Setter
@ToString
public class StudentRequest
{
    private String fname;
    private String lname;
    private String address;
    private String email;
    private long mobilenum;
    private Student.Gender gender;
    private int academicyear;
    private DepartmentRequest departmentRequest;
}
