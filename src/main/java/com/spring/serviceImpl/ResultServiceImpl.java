package com.spring.serviceImpl;

import com.spring.model.Result;
import com.spring.model.Student;
import com.spring.model.StudentSubject;
import com.spring.repository.ResultRepository;
import com.spring.repository.StudentRepository;
import com.spring.repository.StudentSubjectRepository;
import com.spring.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService
{
    @Autowired
    private StudentSubjectRepository studentSubjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public Result generateResult(int studentid)
    {
        //fetch student
        Student student = studentRepository.findById(studentid).orElseThrow(() -> new RuntimeException("Student not found"));

        //fetch all subjects
        List<StudentSubject> subjectList = studentSubjectRepository.findByStudentid(studentid);
         if(subjectList.isEmpty())
         {
             throw new RuntimeException("No marks entered for the student");
         }

         //calculating total marks
        long totalmarks = subjectList.stream()
                .mapToLong(StudentSubject::getMarksobt)
                .sum();

         //number of backlog
         int activebacklogs = (int) subjectList.stream()
                 .filter(s -> s.getMarksobt()<35)
                 .count();

         //calculate percentage
        long percentage = (totalmarks * 100)/ (subjectList.size() * 100);

        //calculate grade
        String grade;
        if(percentage>90)
        {
            grade = "A1";
        } else if (percentage>80)
        {
            grade = "A2";
        }
        else if (percentage>70)
        {
            grade = "B1";
        }
        else if (percentage>60)
        {
            grade = "B2";
        }
        else if (percentage>50)
        {
            grade = "C1";
        }
        else if (percentage>40)
        {
            grade = "C2";
        }
        else if (percentage>35)
        {
            grade = "D";
        }
        else
        {
            grade = "Fail";
        }

        //saving result
        Result result= new Result();
        result.setStudent(student);
        result.setTotalmarks(totalmarks);
        result.setPercentage(percentage);
        result.setGrade(grade);
        result.setActivebacklogs(activebacklogs);

        return resultRepository.save(result);
    }
}
