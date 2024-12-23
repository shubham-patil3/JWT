package com.example.JWTAuthentication.controllers;

import com.example.JWTAuthentication.models.User;
import com.example.JWTAuthentication.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getUser(){
        System.out.println("Getting users");
        return userService.getUsers();
    }

    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }
}
