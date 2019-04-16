package com.example.apimanage.controller;

import com.example.apimanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestBody Map<String, String> params){
        System.out.println(params);

        System.out.println(params.get("email"));

        Map<String, Object> result = userService.login(params);

        return result;
    }
}
