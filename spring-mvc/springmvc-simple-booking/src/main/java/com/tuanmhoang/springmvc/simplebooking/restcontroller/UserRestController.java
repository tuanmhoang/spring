package com.tuanmhoang.springmvc.simplebooking.restcontroller;

import com.tuanmhoang.springmvc.simplebooking.entity.User;
import com.tuanmhoang.springmvc.simplebooking.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserRestController {

    private final UserService userService;

    @GetMapping("all")
    public List<User> getUsers(){
        return userService.findAll();
    }
}
