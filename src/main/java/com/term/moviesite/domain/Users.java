package com.term.moviesite.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Users {
    @Id
    @Column(name="USER_ID", nullable = false)
    private String userId;

    @Column(name="PASSWORD", nullable = false)
    private String password;

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="AGE", nullable = false)
    private Short age;

    @Enumerated(EnumType.STRING)
    @Column(name="GENDER", nullable = false)
    private Gender gender;

    @OneToMany(mappedBy="user", cascade = CascadeType.REMOVE)
    private List<Tickets> tickets = new ArrayList<Tickets>();

    @OneToMany(mappedBy="user", cascade = CascadeType.REMOVE)
    private List<Reviews> reviews = new ArrayList<Reviews>();

    public Users(String userId, String password, String name, Short age, Gender gender) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
