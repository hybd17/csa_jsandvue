package com.example.csa_jsandvue.service;


import com.example.csa_jsandvue.entity.loginUser;



public interface UserService {
    loginUser login(loginUser loginUser);
    loginUser findUserByUsername(String username);
}
