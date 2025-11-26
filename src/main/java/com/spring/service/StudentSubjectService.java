package com.spring.service;

import com.spring.model.StudentSubject;

public interface StudentSubjectService {
    StudentSubject updateMarks(int id, int subid, int marks);
}
