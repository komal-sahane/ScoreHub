package com.spring.controller;

import com.spring.model.StudentSubject;
import com.spring.service.StudentSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/StudentSubject")
public class StudentSubjectController
{
    @Autowired
    private StudentSubjectService studentSubjectService;

    @PutMapping("update/marks/{id}/{subid}")
    public ResponseEntity<StudentSubject> updateMarksById(
            @PathVariable int id,
            @PathVariable int subid,
            @RequestBody StudentSubject studentSubject)
    {
        StudentSubject updateMarksById = studentSubjectService.updateMarks
                ( id, subid, studentSubject.getMarksobt());
        return new ResponseEntity<>(updateMarksById, HttpStatus.OK);
    }


}
