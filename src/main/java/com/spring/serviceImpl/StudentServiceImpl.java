package com.spring.serviceImpl;

import com.spring.model.Department;
import com.spring.model.Student;
import com.spring.model.StudentSubject;
import com.spring.model.Subject;
import com.spring.repository.DepartmentRepository;
import com.spring.repository.StudentRepository;
import com.spring.repository.StudentSubjectRepository;
import com.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private StudentSubjectRepository studentSubjectRepository;
    @Override
    public String saveStudent(Student student)
    {

        Department department = departmentRepository.findById(student.getDepartment().getDepartmentid())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        student.setDepartment(department);
        Student savedStudent = studentRepository.save(student);
        List<Subject> departmentsubject = department.getSubject();

        for(Subject subject : departmentsubject)
        {
            StudentSubject studentSubject = new StudentSubject();
            studentSubject.setStudentid(savedStudent.getId());
            studentSubject.setSubid(subject.getSubid());
            studentSubject.setMarksobt(null);

            studentSubjectRepository.save(studentSubject);
        }
        return "Student Saved";



//        Student student = new Student();
//        student.setFname(request.getFname());
//        student.setLname(request.getLname());
//        student.setAddress(student.getAddress());
//        student.setEmail(request.getAddress());
//        student.setMobilenum(request.getMobilenum());
//        student.setGender(request.getGender());
//        student.setAcademicyear(request.getAcademicyear());
//
//        DepartmentRequest departmentRequest = request.getDepartmentRequest();
//
//        Department departmentt = departmentRepository
//                .findBydepartmentnameAndSemester(departmentRequest.getDepartmentname(),
//                        departmentRequest.getSemester())
//                .orElseGet(() -> {
//        Department department = new Department();
//        department.setDepartmentname(departmentRequest.getDepartmentname());
//        department.setSemester(departmentRequest.getSemester());
//        return departmentRepository.save(department);
//                });


    }

    @Override
    public List<Student> getAllStudent()
    {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }
}
