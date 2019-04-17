package com.example.apimanage.service;

import com.example.apimanage.domain.query.Register;

import java.util.Map;


public interface UserService {
    Map getUserByName(String username);

    Map login(String email, String password);

    int register(Register register);

    int modify(Map<String, Object> user);
}
