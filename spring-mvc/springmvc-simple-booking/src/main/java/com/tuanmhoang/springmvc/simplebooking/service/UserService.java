package com.tuanmhoang.springmvc.simplebooking.service;

import com.tuanmhoang.springmvc.simplebooking.entity.User;
import java.util.List;

public interface UserService {
    User getByEmail(String email);

    User getById(long userId);

    boolean delete(long userId);

    User create(User user);

    User update(User user);

    List<User> getByName(String name, int pageSize, int pageNum);

    List<User> findAll();
}
