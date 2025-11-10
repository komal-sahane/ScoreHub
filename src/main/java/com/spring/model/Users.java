package com.spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Users
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    private String username;
    private String password;
    private String email;
    private enum role
    {
        ADMIN,
        TEACHER,
        STUDENT
    }
    @Enumerated(EnumType.STRING)
    private role role;

}
