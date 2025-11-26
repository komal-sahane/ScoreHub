package com.spring.repository;

import com.spring.model.StudentSubject;
import com.spring.model.StudentSubjectId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentSubjectRepository extends JpaRepository<StudentSubject, StudentSubjectId>
{
    List<StudentSubject> findByStudentid(int studentid);

    StudentSubject findByStudentidAndSubid(int studentid, int subid);

}
