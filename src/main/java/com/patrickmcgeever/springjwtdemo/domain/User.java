package com.patrickmcgeever.springjwtdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "USER")
@DiscriminatorValue("USER")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements Serializable {

    @Id
    @Column(name = "USERNAME", nullable = false, unique = true)
    @Getter
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    @With
    @Getter
    private String password;

    @Column(name = "FIRST_NAME", nullable = false)
    @Getter
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    @Getter
    private String lastName;

    @Column(name = "EMAIL", nullable = false, unique = true)
    @Getter
    private String email;

}
