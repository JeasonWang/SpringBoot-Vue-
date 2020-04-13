package com.wanghuan.blogserver.service.impl;

import com.wanghuan.blogserver.dao.UserDao;
import com.wanghuan.blogserver.entity.User;
import com.wanghuan.blogserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User queryById(Integer id) {
        return userDao.queryById(id);
    }

    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return userDao.queryAllByLimit(offset,limit);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int update(User user) { return userDao.update(user); }

    @Override
    public int deleteById(Integer id) {
        return userDao.deleteById(id);
    }

    @Override
    public User queryByUsnAndPsd(String username, String password) {
        return userDao.queryByUsnAndPsd(username,password);
    }

    @Override
    public int isAdmin(int id) {
        return userDao.isAdmin(id);
    }
}
