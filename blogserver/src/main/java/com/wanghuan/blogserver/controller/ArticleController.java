package com.wanghuan.blogserver.controller;

import com.wanghuan.blogserver.entity.Article;
import com.wanghuan.blogserver.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @GetMapping("/all")
    public Map<String,Object> all(@RequestParam(defaultValue = "-1") Integer state, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "6") Integer count, String keywords){
        System.out.println("all");
        List<Article> articles = articleService.queryAllByStateAndKeywords(state, page, count, keywords);
        int totalCount = articleService.totalCount(state);
        Map<String,Object> map = new HashMap();
        map.put("totalCount",totalCount);
        map.put("articles",articles);
        return map;
    }
}