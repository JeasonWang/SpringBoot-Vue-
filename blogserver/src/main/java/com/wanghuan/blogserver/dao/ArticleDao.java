package com.wanghuan.blogserver.dao;

import com.wanghuan.blogserver.entity.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Article)表数据库访问层
 *
 * @author wanghuan
 * @since 2020-04-12 21:16:23
 */

public interface ArticleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Article queryById(Integer id);

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 影响行数
     */
    int insert(Article article);

    /**
     * 通过主键删除数据
     *
     * @param aids 主键
     * @return 影响行数
     */
    int deleteById(@Param("aids") Integer[] aids);

    List<Article> getArticleByState(@Param("state") int state, @Param("offset") int offset,@Param("limit") int limit, @Param("keywords") String keywords,@Param("uid")int uid);

    int getArticleCountByState(@Param("state") Integer state, @Param("uid") Integer uid, @Param("keywords") String keywords);

    int updateArticleState(@Param("aids") Integer[] aids, @Param("state") Integer state);

    int updateArticleStateById(@Param("aid") Integer aid, @Param("state") Integer state);

    int addArticle(Article article);

    int updateArticle(Article article);
}