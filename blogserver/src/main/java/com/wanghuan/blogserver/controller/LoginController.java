package com.wanghuan.blogserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.wanghuan.blogserver.annotation.PassToken;
import com.wanghuan.blogserver.entity.User;
import com.wanghuan.blogserver.service.UserService;
import com.wanghuan.blogserver.util.TokenUtil;
import com.wanghuan.blogserver.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @PassToken
    @PostMapping("/login")
    public String login(String username, String password) throws JsonProcessingException {
        JSONObject jsonObject=new JSONObject();
        User uu = userService.queryById(7);
        User userForBase=userService.queryByUsnAndPsd(username,password);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
        }else {
            Util.setCurrentUser(userForBase);
            String token = TokenUtil.getToken(userForBase);
            jsonObject.put("token", token);
            jsonObject.put("user", userForBase);
        }
        return jsonObject.toJSONString();
    }

    @PassToken
    @GetMapping("/logout")
    public void logout(){

    }
}
