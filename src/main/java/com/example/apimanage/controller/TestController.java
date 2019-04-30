package com.example.apimanage.controller;

import com.example.apimanage.domain.query.ListUser;
import com.example.apimanage.redis.RedisJedisUtil;
import com.example.apimanage.redis.RedisTemplateUtil;
import com.example.apimanage.redis.SerializeUtil;
import com.example.apimanage.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private RedisJedisUtil redisUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplateUtil redisTemplateUtil;
    @RequestMapping(value = "setUserList1",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户列表1",response =String.class)
    public String setUserList1(){
        try{
            List<ListUser> listUsers=userService.getUserList();
            redisUtil.set("userList1".getBytes(),SerializeUtil.serialize(listUsers),0);
            return "bbb";

        }catch (Exception e){
            return "aaa";
        }
    }
    @RequestMapping(value = "getUserList1",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户列表1",response =String.class)
    public List getUserList1(){
        try{
           List<ListUser> listUsers=(List<ListUser>) SerializeUtil.unserizlize(redisUtil.get("userList1".getBytes(),0));
            for (ListUser u :
                    listUsers) {
                System.out.println(u.getNickname());

            }
            return listUsers;

        }catch (Exception e){
            return null;
        }
    }

    @RequestMapping(value = "setUserList2",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户列表1",response =String.class)
    public String setUserList2(){
        try{
            List<ListUser> listUsers=userService.getUserList();
            redisTemplateUtil.set("userList2",listUsers);
            return "bbb";
        }catch (Exception e){
            return "aaa";
        }
    }
    @RequestMapping(value = "getUserList2",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户列表1",response =String.class)
    public Object getUserList2(){
        try{
            Object listUsers= redisTemplateUtil.get("userList2");
            System.out.println(listUsers);
            return listUsers;
        }catch (Exception e){
            return null;
        }
    }
}
