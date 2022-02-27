package com.tuanmhoang.spring.xml.service.impl;

import com.tuanmhoang.spring.xml.dao.UserDao;
import com.tuanmhoang.spring.xml.model.User;
import com.tuanmhoang.spring.xml.service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public User getById(long userId) {
        return null;
    }

    @Override
    public boolean delete(long userId) {
        return false;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public List<User> getByName(String name, int pageSize, int pageNum) {
        return null;
    }
}
