package com.spring.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Entity
@Getter
@Setter
@ToString
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int id;
    private String fname;
    private String lname;
    private String address;
    private String email;
    private long mobilenum;
    public enum Gender
    {
        FEMALE,
        MALE,
        OTHER
    }
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int academicyear;



    @ManyToOne
    @JoinColumn(name = "departmentid")
    private Department department;


    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "studentid"),
            inverseJoinColumns = @JoinColumn(name = "subjectid")
    )
    private List<Subject> subject;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "result_resultid")
    private Result result;

}
