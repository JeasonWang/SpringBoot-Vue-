package com.wanghuan.blogserver.controller;

import com.wanghuan.blogserver.entity.Article;
import com.wanghuan.blogserver.entity.RespBean;
import com.wanghuan.blogserver.service.ArticleService;
import com.wanghuan.blogserver.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @GetMapping("/all")
    public Map<String, Object> getArticleByState(@RequestParam(value = "state", defaultValue = "-1") Integer state, @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "count", defaultValue = "6") Integer count,String keywords) {
        int totalCount = articleService.getArticleCountByState(state, Util.getCurrentUser().getId(),keywords);
        List<Article> articles = articleService.getArticleByState(state, page, count,keywords);
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", totalCount);
        map.put("articles", articles);
        return map;
    }
    @PostMapping("/")
    public RespBean addArticle(Article article){
        if(articleService.addArticle(article) == 1){
            return new RespBean("success",article.getId()+"添加");
        }
        return new RespBean("error",article.getState() == 0?"文章保存失败":"文章发表失败");
    }
    @GetMapping("/{aid}")
    public Article getArticleById(@PathVariable Integer aid){
        return articleService.queryById(aid);
    }
    @PutMapping("/dustbin")
    public RespBean updateArticleState(Integer[] aids,Integer state){
        if(articleService.updateArticleState(aids,state) == aids.length){
            return new RespBean("success","删除成功");
        }
        return new RespBean("error","删除失败");
    }
    @PutMapping("/restore")
    public RespBean restoreArticle(Integer articleId) {
        if (articleService.updateArticleStateById(articleId, 1) == 1)
            return new RespBean("success", "还原成功");
        return new RespBean("error","还原失败");
    }
}
