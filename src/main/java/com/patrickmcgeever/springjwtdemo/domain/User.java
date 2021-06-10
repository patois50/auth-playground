package com.patrickmcgeever.springjwtdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "user")
@DiscriminatorValue("user")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements Serializable {

    @Id
    @Column(name = "username", nullable = false, unique = true)
    @Getter
    private String username;

    @Column(name = "password", nullable = false)
    @With
    @Getter
    private String password;

    @Column(name = "first_name", nullable = false)
    @Getter
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Getter
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    @Getter
    private String email;
}
