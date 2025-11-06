package com.spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Entity
@Getter
@Setter
@ToString
public class Subject
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Sub_id;
    private String Sub_Name;
    private String Sub_Code;
    private String Max_Marks;
    private long Marks_obtain;
    private String Teacher_Name;
    @ManyToMany
    (mappedBy = "subject")
    private List<Student> student;

}
