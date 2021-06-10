package com.patrickmcgeever.springjwtdemo.controller;

import com.patrickmcgeever.springjwtdemo.domain.User;
import com.patrickmcgeever.springjwtdemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {
    private @Autowired UserService userService;

    @PostMapping()
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        userService.saveDto(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
