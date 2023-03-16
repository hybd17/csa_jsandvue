package com.example.csa_jsandvue.controller;


import com.example.csa_jsandvue.entity.JsonResult;
import com.example.csa_jsandvue.entity.loginUser;
import com.example.csa_jsandvue.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.runtime.ObjectMethods;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {
    public static final int win = 200;
    public static final int lose = 300;


    @Resource
    private UserService userService;
    @PostMapping ("/login")
    private JsonResult<loginUser> login(@RequestBody loginUser loginUser){
        loginUser user;
        try{
            user = userService.login(loginUser);
            if(user != null){
                return new JsonResult<>(win,"登陆成功！",user);
            }
            else {
                user = userService.findUserByUsername(loginUser.getUsername());
                if(user==null){
                    return new JsonResult<>(lose,"用户名不存在");
                }
                else
                    return new JsonResult<>(lose,"密码错误");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new JsonResult<>();
    }
}
