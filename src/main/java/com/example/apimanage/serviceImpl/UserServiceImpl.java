package com.example.apimanage.serviceImpl;

import com.example.apimanage.dao.UserMapper;
import com.example.apimanage.domain.dto.User;
import com.example.apimanage.domain.query.ListUser;
import com.example.apimanage.domain.query.Register;
import com.example.apimanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserInfoById(int userId){

        return userMapper.selectUserById(userId);
    }

    @Override
    public Map login(String email, String password){

        return userMapper.login(email, password);
    }

    @Override
    public int register(Register register) {

        return userMapper.register(register);
    }

    @Override
    public int modify(Map<String, Object> user) {
        return userMapper.modify(user);
    }

    @Override
    public List<ListUser> getUserList() {
        return userMapper.getUserList();
    }
}
