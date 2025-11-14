package com.spring.service;

import com.spring.model.Subject;

import java.util.List;

public interface SubjectService
{
    String saveSubject(Subject subject);

    List<Subject> getAllSubject();
}
