package com.example.apimanage.serviceImpl;

import com.example.apimanage.dao.UserMapper;
import com.example.apimanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Map getUserByName(String username){

        return userMapper.selectUserByName(username);
    }
}
