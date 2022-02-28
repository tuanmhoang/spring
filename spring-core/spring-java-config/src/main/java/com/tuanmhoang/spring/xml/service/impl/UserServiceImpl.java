package com.tuanmhoang.spring.xml.service.impl;

import com.tuanmhoang.spring.xml.dao.UserDao;
import com.tuanmhoang.spring.xml.model.User;
import com.tuanmhoang.spring.xml.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
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
