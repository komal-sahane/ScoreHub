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
    private int resultid;
    private long totalmarks;
    private long percentage;
    private String grade;
    private int activebacklogs;
    @OneToOne
    @JoinColumn(name = "studentid")
    private Student student;

}
