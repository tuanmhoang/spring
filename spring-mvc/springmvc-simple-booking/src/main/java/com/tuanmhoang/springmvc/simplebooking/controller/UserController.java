package com.tuanmhoang.springmvc.simplebooking.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class UserController {

    @GetMapping("/user")
    public String goToEventPage() {
        log.info("Going to user page");
        return "user";
    }
}
