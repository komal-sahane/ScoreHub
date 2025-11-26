package com.spring.model;

import lombok.*;

import java.io.Serializable;
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSubjectId implements Serializable
{
    private int studentid;
    private int subid;
}
