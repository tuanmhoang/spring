package com.tuanmhoang.spring.xml.service;

import com.tuanmhoang.spring.xml.model.User;
import java.util.List;

public interface UserService {
    User getByEmail(String email);

    User getById(long userId);

    boolean delete(long userId);

    User create(User user);

    User update(User user);

    List<User> getByName(String name, int pageSize, int pageNum);
}
