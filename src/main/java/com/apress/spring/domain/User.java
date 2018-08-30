package com.apress.spring.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "USERS")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "name", nullable = false, length = 150)
    private String name;
    @Column(name = "email", nullable = false, length = 150)
    private String email;
    @Column(name = "password", nullable = false, length = 150)
    private String password;

    @OneToMany
    private List<Post> posts;
}