package com.wanghuan.blogserver.controller;

import com.wanghuan.blogserver.annotation.UserLoginToken;
import com.wanghuan.blogserver.entity.Article;
import com.wanghuan.blogserver.entity.Role;
import com.wanghuan.blogserver.entity.User;
import com.wanghuan.blogserver.service.ArticleService;
import com.wanghuan.blogserver.service.UserService;
import com.wanghuan.blogserver.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UserLoginToken
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ArticleService articleService;
    @Autowired
    UserService userService;

    @GetMapping("/article/all")
    public Map<String,Object> all(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "6") Integer count, String keywords){
        List<Article> articles = articleService.getArticleByState(-2, page, count, keywords);
        int totalCount = articleService.getArticleCountByState(1, null,keywords);
        Map<String,Object> map = new HashMap();
        map.put("totalCount",totalCount);
        map.put("articles",articles);
        return map;
    }
    @GetMapping("/user")
    public List<User> getUsers(String nickname){
        System.out.println(nickname);
        List<User> users = userService.queryNickname(nickname);
        return users;
    }
    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        List<Role> roles = userService.getAllRoles(Util.getCurrentUser().getId());
        return roles;
    }
}
