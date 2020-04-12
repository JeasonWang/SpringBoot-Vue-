package com.wanghuan.blogserver.service;

import com.wanghuan.blogserver.entity.Tags;
import java.util.List;

/**
 * (Tags)表服务接口
 *
 * @author makejava
 * @since 2020-04-12 21:16:24
 */
public interface TagsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Tags queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Tags> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tags 实例对象
     * @return 实例对象
     */
    Tags insert(Tags tags);

    /**
     * 修改数据
     *
     * @param tags 实例对象
     * @return 实例对象
     */
    Tags update(Tags tags);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}