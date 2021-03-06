package com.example.apimanage.controller;

import com.example.apimanage.domain.dto.User;
import com.example.apimanage.domain.query.ListUser;
import com.example.apimanage.redis.RedisJedisUtil;
import com.example.apimanage.utils.Result;
import com.example.apimanage.domain.query.Login;
import com.example.apimanage.domain.query.Register;
import com.example.apimanage.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


/**
 * 用户 接口
 *
 * @data: 2019/4/17
 * @author: houser
 */
@RestController
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户信息",response = String.class)
    public Map<String, Object> getUserInfo(@RequestBody int id){
        System.out.println(id);
//        if(userId != null) {
            try{
                User result = userService.getUserInfoById(id);
                if(result!=null){
                    return Result.successResult(result);
                }else{
                    return Result.errorResult("获取失败");
                }
            }catch (Exception e){
                return Result.errorResult(e.getMessage());
            }
//        }
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录",response = String.class)
    public Map<String, Object> login(@RequestBody @Valid Login loginParam){
        System.out.println(loginParam.getEmail());
        try{
            Map<String, Object> result = userService.login(loginParam.getEmail(), loginParam.getPassword());
            if(result!=null){
                return Result.successResult("登录成功");
            }else{
                return Result.errorResult("验证失败");
            }
        }catch (Exception e){
            return Result.errorResult(e.getMessage());
        }

    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "注册",response = String.class)
    public Map<String, Object> register(@RequestBody @Valid Register register){

        try{
            int rows = userService.register(register);
            if(rows >= 1) {
                return Result.successResult("注册成功");
            } else {
                return Result.errorResult("注册失败");
            }
        }catch (Exception e){
            return Result.errorResult(e.getMessage());
        }
    }
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ApiOperation(value = "更新个人信息",response = String.class)
    public Map<String, Object> modify(@RequestBody Map<String, Object> user){
        if(user.get("id") != null && user.size() > 1) {
            try{
                int rows = userService.modify(user);
                if(rows >= 1) {
                    return Result.successResult("更新成功");
                } else {
                    return Result.errorResult("更新失败");
                }
            }catch (Exception e){
                return Result.errorResult(e.getMessage());
            }
        } else {
            return Result.errorResult("参数错误");
        }
    }
    @RequestMapping(value = "getUserList",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户列表",response =String.class)
    public Map<String,Object> getUserList(){
        try{
                List<ListUser> list=userService.getUserList();
                return Result.successResult(list);
        }catch (Exception e){
            return Result.errorResult("服务器错误");
        }
    }


}
