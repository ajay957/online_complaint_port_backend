package com.example.OnlineComplaintReportingPort.controller;

import com.example.OnlineComplaintReportingPort.dao.UserDao;
import com.example.OnlineComplaintReportingPort.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao dao;

    @GetMapping("/")
    public String homePage(){
        return "welcome to home page";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userreg",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> UserRegister(@RequestBody Users u){
        HashMap<String,String> map =new HashMap<>();
        List<Users> r=(List<Users>) dao.UserFind(u.getUsername());
        if(r.size() !=0){
            map.put("status","failed");
        }
        else {
            dao.save(u);
            map.put("status","success");
        }
        return map;
    }

    @CrossOrigin
    @PostMapping(path = "/user",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> UserLogin(@RequestBody Users u){
        List<Users> r = (List<Users>) dao.UserLogin(u.getUsername(),u.getPassword());
        HashMap<String,String> map =new HashMap<>();
        if (r.size()==0){
            map.put("ststus","failed");
        }
        else {
           map.put("status","success");
       }
        return map;
    }
}
