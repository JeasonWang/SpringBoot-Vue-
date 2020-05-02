package com.wanghuan.blogserver.service.impl;

import com.wanghuan.blogserver.dao.ArticleDao;
import com.wanghuan.blogserver.dao.TagsDao;
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
    @Autowired
    TagsDao tagsDao;
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
        //处理文章摘要
        if (article.getSummary() == null || "".equals(article.getSummary())) {
            //直接截取
            String stripHtml = stripHtml(article.getHtmlContent());
            article.setSummary(stripHtml.substring(0, stripHtml.length() > 50 ? 50 : stripHtml.length()));
        }
        if (article.getId() == -1) {
            //添加操作
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            if (article.getState() == 1) {
                //设置发表日期
                article.setPublishDate(timestamp);
            }
            article.setEditTime(timestamp);
            //设置当前用户
            article.setUid(Util.getCurrentUser().getId());
            int i = articleDao.addArticle(article);
            //打标签
            String[] dynamicTags = article.getDynamicTags();
            if (dynamicTags != null && dynamicTags.length > 0) {
                int tags = addTagsToArticle(dynamicTags, article.getId());
                if (tags == -1) {
                    return tags;
                }
            }
            return i;
        } else {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            if (article.getState() == 1) {
                //设置发表日期
                article.setPublishDate(timestamp);
            }
            //更新
            article.setEditTime(new Timestamp(System.currentTimeMillis()));
            int i = articleDao.updateArticle(article);
            //修改标签
            String[] dynamicTags = article.getDynamicTags();
            if (dynamicTags != null && dynamicTags.length > 0) {
                int tags = addTagsToArticle(dynamicTags, article.getId());
                if (tags == -1) {
                    return tags;
                }
            }
            return i;
        }
    }
    public String stripHtml(String content) {
        content = content.replaceAll("<p .*?>", "");
        content = content.replaceAll("<br\\s*/?>", "");
        content = content.replaceAll("\\<.*?>", "");
        return content;
    }
    private int addTagsToArticle(String[] dynamicTags, Integer aid) {
        //1.删除该文章目前所有的标签
        tagsDao.deleteTagsByAid(aid);
        //2.将上传上来的标签全部存入数据库
        tagsDao.saveTags(dynamicTags);
        //3.查询这些标签的id
        List<Integer> tIds = tagsDao.getTagsIdByTagName(dynamicTags);
        //4.重新给文章设置标签
        int i = tagsDao.saveTags2ArticleTags(tIds, aid);
        return i == dynamicTags.length ? i : -1;
    }
}
