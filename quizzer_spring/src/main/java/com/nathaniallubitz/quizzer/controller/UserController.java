package com.nathaniallubitz.quizzer.controller;

import com.nathaniallubitz.quizzer.entity.User;
import com.nathaniallubitz.quizzer.pojo.UserPOJO;
import com.nathaniallubitz.quizzer.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public UserPOJO answerToUniverse(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserPOJO newUser(@RequestBody UserPOJO user) {
        return userService.addUser(user);
    }

}
