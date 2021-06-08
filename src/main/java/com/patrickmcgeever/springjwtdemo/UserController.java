package com.patrickmcgeever.springjwtdemo;

import com.patrickmcgeever.springjwtdemo.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping()
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        userService.saveDto(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
