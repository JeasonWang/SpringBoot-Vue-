package com.wanghuan.blogserver.service.impl;

import com.wanghuan.blogserver.entity.User;
import com.wanghuan.blogserver.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User queryById(Integer id) {
        return null;
    }

    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public User insert(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}
