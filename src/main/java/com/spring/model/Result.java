package com.spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Result
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int result_id;
    private long total_marks;
    private long percentage;
    private String grade;
    private int activebacklogs;
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
