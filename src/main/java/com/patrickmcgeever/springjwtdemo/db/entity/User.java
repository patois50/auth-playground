package com.patrickmcgeever.springjwtdemo.db.entity;

import net.bytebuddy.asm.Advice;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "USER")
@DiscriminatorValue("USER")
public class User implements Serializable {

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

}
