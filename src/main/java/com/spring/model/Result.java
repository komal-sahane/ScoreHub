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
    private long Total_Marks;
    private long Percentage;
    private String Grade;
    private int ActiveBacklogs;
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
