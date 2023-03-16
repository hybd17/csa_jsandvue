package com.example.csa_jsandvue.service.impl;


import com.example.csa_jsandvue.entity.loginUser;
import com.example.csa_jsandvue.mapper.userMapper;
import com.example.csa_jsandvue.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private userMapper userMapper;
    @Override
    public loginUser login(loginUser loginUser) {
        return userMapper.login(loginUser);
    }

    @Override
    public loginUser findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }
}
