package com.spring.controller;

import com.spring.model.Subject;
import com.spring.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController
{
    @Autowired
    private SubjectService subjectService;

    @PostMapping("/subject")
    public ResponseEntity<String> addSubject(@RequestBody Subject subject)
    {
        System.err.println(subject);
        subjectService.saveSubject(subject);
        return new ResponseEntity<>("Subject saved", HttpStatus.CREATED);
    }

    @GetMapping("/showData")
    public ResponseEntity<List<Subject>> allSubject()
    {
        List<Subject> subjectList = subjectService.getAllSubject();
        return new ResponseEntity<>(subjectList, HttpStatus.OK);
    }
}
