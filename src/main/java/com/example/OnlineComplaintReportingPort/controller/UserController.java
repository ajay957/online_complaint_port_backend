package com.example.OnlineComplaintReportingPort.controller;

import com.example.OnlineComplaintReportingPort.dao.UserDao;
import com.example.OnlineComplaintReportingPort.model.Users;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserDao dao;

    @GetMapping("/")
    public String homePage(){
        return "welcome to home page";
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/userreg")
    public String UserRegister(@RequestBody Users u){
        System.out.println(u.getName());
        System.out.println(u.getAddress());
        System.out.println(u.getPhno());
        System.out.println(u.getEmail());
        System.out.println(u.getPassword());
        System.out.println(u.getConfirmPassword());
        dao.save(u);
        return "welcome to user registration";
    }

}
