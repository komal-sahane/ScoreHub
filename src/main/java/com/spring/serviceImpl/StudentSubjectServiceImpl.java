package com.spring.serviceImpl;

import com.spring.model.StudentSubject;
import com.spring.model.StudentSubjectId;
import com.spring.repository.StudentSubjectRepository;
import com.spring.service.StudentSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentSubjectServiceImpl implements StudentSubjectService
{
    @Autowired
    private StudentSubjectRepository studentSubjectRepository;

    @Override
    public StudentSubject updateMarks(int id, int subid, int marks)
    {
        StudentSubjectId newid = new StudentSubjectId(id, subid);
        StudentSubject studentSubject = studentSubjectRepository.findById(newid).orElseThrow(() -> new NullPointerException("No Data Found"));
        studentSubject.setMarksobt(marks);
        StudentSubject updateMarksById = studentSubjectRepository.save(studentSubject);

        return updateMarksById;
    }
}
