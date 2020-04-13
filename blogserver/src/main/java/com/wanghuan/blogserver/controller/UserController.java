package com.wanghuan.blogserver.controller;

import com.wanghuan.blogserver.entity.User;
import com.wanghuan.blogserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/currentUserName")
    public String getCurrentUser(){
        return userService.queryById(7).getUsername();
    }
    @GetMapping("/currentUserEmail")
    public String getCurrentUserEmail(){
        return userService.queryById(7).getEmail();
    }
    @GetMapping("/isAdmin")
    public boolean isAdmin(){
        return userService.isAdmin(7)>0;
    }
}
