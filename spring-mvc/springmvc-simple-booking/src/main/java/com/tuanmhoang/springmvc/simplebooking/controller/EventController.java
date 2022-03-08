package com.tuanmhoang.springmvc.simplebooking.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class EventController {

    @GetMapping("/event")
    public String goToEventPage() {
        log.info("Going to event page");
        return "event";
    }
}
