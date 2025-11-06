package com.spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Year;
import java.util.List;
@Entity
@Getter
@Setter
@ToString
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String Fname;
    private String Lname;
    private String Address;
    private String Email;
    private long MobileNum;
    private String Department;
    public enum Gender
    {
        FEMALE,
        MALE,
        OTHER
    }
    @Enumerated(EnumType.STRING)
    private Gender gender;
    public  enum Semester{
        I,
        II,
        III,
        IV,
        V,
        VI,
        VII,
        VIII

    }
    @Enumerated(EnumType.STRING)
    private Semester semester;
    private Year AcademicYear;
    @ManyToMany
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subject;
    @OneToOne
    @JoinColumn(name = "result_result_id")
    private Result result;

}
