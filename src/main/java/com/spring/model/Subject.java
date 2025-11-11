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
public class Subject
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int sub_id;
    private String sub_name;
    private String sub_code;
    private String max_marks;
    private long marks_obtain;
    private String teacher_name;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @JsonIgnore
    @ManyToMany
    (mappedBy = "subject")
    private List<Student> student;
}
