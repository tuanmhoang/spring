package com.tuanmhoang.spring.xml.dao.impl;

import com.tuanmhoang.spring.xml.dao.UserDao;
import com.tuanmhoang.spring.xml.data.UserData;
import com.tuanmhoang.spring.xml.mapper.UserMapper;

public class UserDaoImpl implements UserDao {

    private UserData userData;

    private UserMapper userMapper;

    public UserDaoImpl(UserData userData, UserMapper userMapper) {
        this.userData = userData;
        this.userMapper = userMapper;
    }
}
