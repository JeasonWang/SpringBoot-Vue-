package com.wanghuan.blogserver.service;

import com.wanghuan.blogserver.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Article)表服务接口
 *
 * @author wanghuan
 * @since 2020-04-12 21:16:23
 */
public interface ArticleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Article queryById(Integer id);

    List<Article> getArticleByState(int state, int page, int count, String keywords);

    int getArticleCountByState(Integer state, Integer uid,String keywords);

    int updateArticleState(Integer[] aids, Integer state);

    int updateArticleStateById(Integer aid, Integer state);

    int addArticle(Article article);
}