package com.spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "users")
public class Users
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int User_id;
    private String Username;
    private String Password;
    private String Email;
    private enum Role
    {
        ADMIN,
        TEACHER,
        STUDENT
    }
    @Enumerated(EnumType.STRING)
    private Role role;

}
