package com.spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@IdClass(StudentSubjectId.class)
@Table(name = "student_subject")
public class StudentSubject
{
    @Id
    @Column(name = "id")
    private int studentid;
    @Id
    @Column(name = "subid")
    private int subid;

    private Integer marksobt;
}
