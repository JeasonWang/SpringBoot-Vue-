package com.wanghuan.blogserver.service.impl;

import com.wanghuan.blogserver.dao.ArticleDao;
import com.wanghuan.blogserver.entity.Article;
import com.wanghuan.blogserver.service.ArticleService;
import com.wanghuan.blogserver.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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

    @Override
    public int updateArticleState(Integer[] aids, Integer state) {
        if (state == 2){
            return articleDao.deleteById(aids);
        }
        return articleDao.updateArticleState(aids,2);
    }

    @Override
    public int updateArticleStateById(Integer aid, Integer state) {
        return articleDao.updateArticleStateById(aid,state);
    }

    @Override
    public int addArticle(Article article) {
        if(article.getSummary() == null || "".equals(article.getSummary())){
            article.setSummary("summary is null");
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        if(article.getId() == -1){
            if (article.getState() == 1){
                article.setPublishDate(timestamp);
            }
            article.setEditTime(timestamp);
            article.setUid(Util.getCurrentUser().getId());
            int n = articleDao.addArticle(article);
            String[] dynamicTags = article.getDynamicTags();
            if(dynamicTags != null && dynamicTags.length>0){

            }
            return n;
        }else {
            if (article.getState() == 1){
                article.setPublishDate(timestamp);
            }
            article.setEditTime(timestamp);
            int n = articleDao.updateArticle(article);
            String[] dynamicTags = article.getDynamicTags();
            if(dynamicTags != null && dynamicTags.length>0){

            }
            return n;
        }
    }
}
