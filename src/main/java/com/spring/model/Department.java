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
public class Department
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int departmentid;
    private String departmentname;
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

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<Student> students;

    @JsonIgnore
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Subject> subject;
}
