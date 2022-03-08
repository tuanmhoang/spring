package com.tuanmhoang.springmvc.simplebooking.controller;

import com.tuanmhoang.springmvc.simplebooking.entity.User;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@Slf4j
public class UserController {

    @GetMapping("/user")
    public String goToEventPage() {
        log.info("Going to user page");
        return "user";
    }

    @ModelAttribute("users")
    public List<User> getDefaultUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Alice", "alice@email.com"));
        users.add(new User(2L, "Bob", "bob@email.com"));
        return users;
    }
}
