package com.tuanmhoang.spring.xml.mapper;

import com.tuanmhoang.spring.xml.entities.UserEntity;
import com.tuanmhoang.spring.xml.model.User;

public interface UserMapper {

    UserEntity userEntityFromUser(User user);
    User userFromUserEntity(UserEntity userEntity);
}
