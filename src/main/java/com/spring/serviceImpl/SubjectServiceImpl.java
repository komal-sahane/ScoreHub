package com.spring.serviceImpl;

import com.spring.repository.SubjectRepository;
import com.spring.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService
{
    @Autowired
    private SubjectRepository subjectRepository;
}
