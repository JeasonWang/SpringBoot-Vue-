package com.wanghuan.blogserver.service.impl;

import com.wanghuan.blogserver.dao.CategoryDao;
import com.wanghuan.blogserver.entity.Category;
import com.wanghuan.blogserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;
    @Override
    public Category queryById(Integer id) {
        return categoryDao.queryById(id);
    }

    @Override
    public List<Category> queryAll(Category category) {
        return categoryDao.queryAll(category);
    }

    @Override
    public List<Category> queryAllByLimit(int offset, int limit) {
        return categoryDao.queryAllByLimit(offset,limit);
    }

    @Override
    public int insert(Category category) {
        return categoryDao.insert(category);
    }

    @Override
    public int update(Category category) {
        return categoryDao.update(category);
    }

    @Override
    public int deleteById(Integer id) {
        return categoryDao.deleteById(id);
    }
}
