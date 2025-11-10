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
    private String fname;
    private String lname;
    private String address;
    private String email;
    private long mobilenum;
    public enum gender
    {
        FEMALE,
        MALE,
        OTHER
    }
    @Enumerated(EnumType.STRING)
    private gender gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    @Schema(type = "string", example = "2025", description = "Academic year in yyyy format")
    private Year academicyear;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


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
