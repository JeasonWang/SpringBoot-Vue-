package com.wanghuan.blogserver.service;

import com.wanghuan.blogserver.entity.RolesUser;
import java.util.List;

/**
 * (RolesUser)表服务接口
 *
 * @author wanghuan
 * @since 2020-04-12 21:16:24
 */
public interface RolesUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RolesUser queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RolesUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param rolesUser 实例对象
     * @return 实例对象
     */
    RolesUser insert(RolesUser rolesUser);

    /**
     * 修改数据
     *
     * @param rolesUser 实例对象
     * @return 实例对象
     */
    RolesUser update(RolesUser rolesUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}