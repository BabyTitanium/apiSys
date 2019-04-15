package com.example.apimanage.service;

import org.springframework.stereotype.Service;

import java.util.Map;


public interface UserService {
    Map getUserByName(String username);

}
