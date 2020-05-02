package com.wanghuan.blogserver.controller;

import com.wanghuan.blogserver.annotation.UserLoginToken;
import com.wanghuan.blogserver.entity.RespBean;
import com.wanghuan.blogserver.entity.User;
import com.wanghuan.blogserver.service.UserService;
import com.wanghuan.blogserver.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@UserLoginToken
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/currentUserName")
    public String getCurrentUser(){
        return Util.getCurrentUser().getNickname();
    }


    @GetMapping("/currentUserEmail")
    public String getCurrentUserEmail(){
        return Util.getCurrentUser().getEmail();
    }


    @GetMapping("/isAdmin")
    public boolean isAdmin(){
        return userService.isAdmin(Util.getCurrentUser().getId())>0;
    }

    @PutMapping("/updateUserEmail")
    public RespBean updateUserEmail(String email){
        if (userService.updateUserEmail(email) == 1) {
            return new RespBean("success", "开启成功!");
        }
        return new RespBean("error", "开启失败!");
    }
    @GetMapping("/currentUser")
    public User getUser(){
        return Util.getCurrentUser();
    }
}
