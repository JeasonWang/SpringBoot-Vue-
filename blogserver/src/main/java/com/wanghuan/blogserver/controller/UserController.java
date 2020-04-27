package com.wanghuan.blogserver.controller;

import com.wanghuan.blogserver.annotation.UserLoginToken;
import com.wanghuan.blogserver.service.UserService;
import com.wanghuan.blogserver.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@UserLoginToken
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @UserLoginToken
    @GetMapping("/currentUserName")
    public String getCurrentUser(){
        return Util.getCurrentUser().getNickname();
    }

    @UserLoginToken
    @GetMapping("/currentUserEmail")
    public String getCurrentUserEmail(){
        return Util.getCurrentUser().getEmail();
    }

    @UserLoginToken
    @GetMapping("/isAdmin")
    public boolean isAdmin(){
        return userService.isAdmin(Util.getCurrentUser().getId())>0;
    }
}
