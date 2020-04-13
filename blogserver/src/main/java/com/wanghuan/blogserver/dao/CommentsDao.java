package com.wanghuan.blogserver.dao;

import com.wanghuan.blogserver.entity.Comments;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Comments)表数据库访问层
 *
 * @author wanghuan
 * @since 2020-04-12 21:16:24
 */
public interface CommentsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Comments queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Comments> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param comments 实例对象
     * @return 对象列表
     */
    List<Comments> queryAll(Comments comments);

    /**
     * 新增数据
     *
     * @param comments 实例对象
     * @return 影响行数
     */
    int insert(Comments comments);

    /**
     * 修改数据
     *
     * @param comments 实例对象
     * @return 影响行数
     */
    int update(Comments comments);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}