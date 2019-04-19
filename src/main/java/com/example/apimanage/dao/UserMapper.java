package com.example.apimanage.dao;

import com.example.apimanage.domain.dto.User;
import com.example.apimanage.domain.query.ListUser;
import com.example.apimanage.domain.query.Register;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author liulingling
 */
@Mapper
@Repository
public interface UserMapper {
     /**
      * fetch data by rule id
      *
      * @param userId
      * @return
      */
     User selectUserById(int userId);

     Map login(@Param("email") String email, @Param("password") String password);

     int register(Register register);

     int modify(Map<String, Object> user);

     List<ListUser> getUserList();

}
