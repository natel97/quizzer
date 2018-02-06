package com.nathaniallubitz.quizzer.controller;

import com.nathaniallubitz.quizzer.entity.Token;
import com.nathaniallubitz.quizzer.entity.User;
import com.nathaniallubitz.quizzer.exception.SessionNotFoundException;
import com.nathaniallubitz.quizzer.exception.UserDefinedException;
import com.nathaniallubitz.quizzer.pojo.UserPOJO;
import com.nathaniallubitz.quizzer.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

   @GetMapping("/user/lookup/{token}")
   public UserPOJO getUserFromToken(@PathVariable String token) throws SessionNotFoundException {
        return userService.getUserByToken(token);
   }


    @GetMapping("/{id}")
    public UserPOJO findById(@PathVariable Integer id, HttpServletResponse response) {
        try {
            return userService.getUserById(id);
        }
        catch(Exception e){
            response.setStatus(404);
            return null;
        }
    }

    @PostMapping
    public UserPOJO newUser(@RequestBody UserPOJO user) {
        return userService.addUser(user);
    }

    @PostMapping("/getToken")
    public String createToken(@RequestBody UserPOJO user, HttpServletResponse response){
        try {
            return userService.createToken(user);
        }
        catch(UserDefinedException e){
            response.setStatus(e.getErrorCode());
            System.out.println("Error Code: " + e.getErrorCode() + "\tMessage: " + e.getErrorMessage());
            return "Error Code: " + e.getErrorCode() + "\tMessage: " + e.getErrorMessage();
        }
    }

}
