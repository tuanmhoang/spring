package com.tuanmhoang.springmvc.simplebooking.service.impl;

import com.tuanmhoang.springmvc.simplebooking.entity.User;
import com.tuanmhoang.springmvc.simplebooking.repository.UserRepository;
import com.tuanmhoang.springmvc.simplebooking.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

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

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
