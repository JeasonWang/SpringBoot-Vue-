package com.wanghuan.blogserver.service.impl;

import com.wanghuan.blogserver.dao.ArticleDao;
import com.wanghuan.blogserver.entity.Article;
import com.wanghuan.blogserver.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;
    @Override
    public Article queryById(Integer id) {
        return articleDao.queryById(id);
    }

    @Override
    public List<Article> queryAll(Article article) {
        return articleDao.queryAll(article);
    }

    @Override
    public List<Article> queryAllByLimit(int offset, int limit) {
        return articleDao.queryAllByLimit(offset,limit);
    }

    @Override
    public int insert(Article article) {
        return articleDao.insert(article);
    }

    @Override
    public int update(Article article) {
        return articleDao.update(article);
    }

    @Override
    public int deleteById(Integer id) {
        return articleDao.deleteById(id);
    }

    @Override
    public List<Article> getArticleByState(int state, int page, int count, String keywords) {
        int offset = (page - 1)*count;
        int limit = count;
        int uid = 7;
        return articleDao.getArticleByState(state,offset,limit,keywords,uid);
    }

    @Override
    public int getArticleCountByState(Integer state, Integer uid,String keywords) {
        return articleDao.getArticleCountByState(state, uid,keywords);
    }
}
