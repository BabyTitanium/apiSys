package com.example.apimanage.controller;

import com.example.apimanage.ResultDetail.Result;
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
        Map<String,String> user=userService.getUserByName("张志明");
        return user.get("password");
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestBody Map<String, String> params){
        try{
            Map<String, Object> result = userService.login(params);
            if(result!=null){
                return Result.successResult("登录成功");
            }else{
                return Result.errorResult("验证失败");
            }
        }catch (Exception e){
            return Result.errorResult("服务器错误");
        }

    }
}
