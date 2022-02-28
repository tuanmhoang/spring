package com.tuanmhoang.spring.xml.mapper.impl;

import com.tuanmhoang.spring.xml.entities.UserEntity;
import com.tuanmhoang.spring.xml.mapper.UserMapper;
import com.tuanmhoang.spring.xml.model.User;
import com.tuanmhoang.spring.xml.model.impl.UserImpl;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {
    @Override
    public UserEntity userEntityFromUser(User user) {
        return new UserEntity(
            user.getId(),
            user.getName(),
            user.getEmail()
        );
    }

    @Override
    public User userFromUserEntity(UserEntity userEntity) {
        return new UserImpl(
            userEntity.getId(),
            userEntity.getName(),
            userEntity.getEmail()
        );
    }
}
