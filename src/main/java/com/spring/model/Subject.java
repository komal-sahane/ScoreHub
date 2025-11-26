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
    private int subid;
    private String subname;
    private String subcode;
    private String maxmarks;
    private String teachername;

    @ManyToOne
    @JoinColumn(name = "departmentid")
    private Department department;

}
