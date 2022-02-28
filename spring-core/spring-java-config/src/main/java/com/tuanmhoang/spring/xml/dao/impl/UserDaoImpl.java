package com.tuanmhoang.spring.xml.dao.impl;

import com.tuanmhoang.spring.xml.dao.UserDao;
import com.tuanmhoang.spring.xml.data.UserDataService;
import com.tuanmhoang.spring.xml.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    private UserDataService userData;

    private UserMapper userMapper;

    @Autowired
    public UserDaoImpl(UserDataService userData, UserMapper userMapper) {
        this.userData = userData;
        this.userMapper = userMapper;
    }
}
