package com.spring.serviceImpl;

import com.spring.model.Subject;
import com.spring.repository.SubjectRepository;
import com.spring.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService
{
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public String saveSubject(Subject subject)
    {
        Subject savesubject = subjectRepository.save(subject);
        return "Subject saved";
    }

    @Override
    public List<Subject> getAllSubject()
    {
        List<Subject> subjectList = subjectRepository.findAll();
        return subjectList;
    }
}
