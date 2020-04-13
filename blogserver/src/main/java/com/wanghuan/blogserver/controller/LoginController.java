package com.wanghuan.blogserver.controller;

import com.wanghuan.blogserver.entity.RespBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/login")
    public RespBean login(){
        return new RespBean("error","未登录");
    }
    @RequestMapping("/tologin")
    public RespBean toLogin(){
        return new RespBean("error","未登录");
    }
}
