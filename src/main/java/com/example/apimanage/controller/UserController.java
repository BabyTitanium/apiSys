package com.example.apimanage.controller;

import com.example.apimanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("getOneUser")
    @ResponseBody
    public String getOneUser(){
        //return "111";

        Map<String,String> user=userService.getUserByName("张志明");
        return user.get("password");
    }
}
