package com.example.apimanage.dao;

import com.example.apimanage.domain.dto.User;
import com.example.apimanage.domain.query.Register;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface UserMapper {
     User selectUserById(int userId);

     Map login(@Param("email") String email, @Param("password") String password);

     int register(Register register);

     int modify(Map<String, Object> user);
}
