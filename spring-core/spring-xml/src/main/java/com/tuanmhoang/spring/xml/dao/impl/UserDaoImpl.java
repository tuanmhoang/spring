package com.tuanmhoang.spring.xml.dao.impl;

import com.tuanmhoang.spring.xml.dao.UserDao;
import com.tuanmhoang.spring.xml.data.UserDataService;
import com.tuanmhoang.spring.xml.mapper.UserMapper;

public class UserDaoImpl implements UserDao {

    private UserDataService userData;

    private UserMapper userMapper;

    public UserDaoImpl(UserDataService userData, UserMapper userMapper) {
        this.userData = userData;
        this.userMapper = userMapper;
    }
}
