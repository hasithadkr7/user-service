package com.example.userservice.controller;

import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser method in UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{Id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("Id") Long userId){
        log.info("Inside getUserWithDepartment method in UserController");
        return userService.getUserWithDepartment(userId);
    }
}
