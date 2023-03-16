package com.example.csa_jsandvue.mapper;

import com.example.csa_jsandvue.entity.loginUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userMapper {
    loginUser login(loginUser loginUser);
    loginUser findUserByUsername(String username);
}
