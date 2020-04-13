package com.wanghuan.blogserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanghuan.blogserver.entity.User;
import com.wanghuan.blogserver.service.UserService;
import com.wanghuan.blogserver.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public String login(String username,String password) throws JsonProcessingException {
        User user1 = userService.queryByUsnAndPsd(username,password);
        if (user1 != null){
            String token= TokenUtil.sign(user1);
            HashMap<String,Object> hs=new HashMap<>();
            hs.put("token",token);
            ObjectMapper objectMapper=new ObjectMapper();
            return objectMapper.writeValueAsString(hs);
        }
        return "";
    }
}
