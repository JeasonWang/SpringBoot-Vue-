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
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Article> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param article 实例对象
     * @return 对象列表
     */
    List<Article> queryAll(Article article);

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 影响行数
     */
    int insert(Article article);

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 影响行数
     */
    int update(Article article);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Article> queryAllByStateAndKeywords(@Param("state") int state, @Param("offset") int offset,@Param("limit") int limit, @Param("keywords") String keywords,@Param("uid")int uid);

    int totalCount(@Param("state") Integer state, @Param("uid") Integer uid, @Param("keywords") String keywords);
}