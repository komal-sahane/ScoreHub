package com.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Admin
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adminid;
    private String adminname;
    private String email;
    private String password;
    private String fullname;
}
