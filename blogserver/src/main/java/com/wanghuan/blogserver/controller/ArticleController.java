package com.wanghuan.blogserver.controller;

import com.wanghuan.blogserver.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @GetMapping("/all")
    public String all(@RequestParam(value = "-1") Integer state, @RequestParam(value = "1") Integer page, @RequestParam(value = "6") Integer count, String keywords){
        return articleService.queryById(108).getTitle();
    }
}
