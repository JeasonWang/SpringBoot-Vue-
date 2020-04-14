package com.wanghuan.blogserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanghuan.blogserver.entity.User;
import com.wanghuan.blogserver.service.UserService;
import com.wanghuan.blogserver.util.TokenUtil;
import com.wanghuan.blogserver.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
public class LoginController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public String login(String username, String password) throws JsonProcessingException {
        User user1 = userService.queryByUsnAndPsd(username,password);
        if (user1 != null){
            Util.setCurrentUser(user1);
            String token= TokenUtil.sign(user1);
            HashMap<String,Object> hs=new HashMap<>();
            hs.put("token",token);
            ObjectMapper objectMapper=new ObjectMapper();
            return objectMapper.writeValueAsString(hs);
        }
        return "";
    }

    @GetMapping("/logout")
    public void logout(){

    }
}
