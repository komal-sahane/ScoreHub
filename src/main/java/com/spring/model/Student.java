package com.spring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @JsonIgnore
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    @Schema(type = "string", example = "2025", description = "Academic year in yyyy format")
    private Year AcademicYear;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subject;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "result_result_id")
    private Result result;

}
