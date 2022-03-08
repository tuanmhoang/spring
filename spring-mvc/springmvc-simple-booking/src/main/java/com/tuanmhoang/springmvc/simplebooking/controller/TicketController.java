package com.tuanmhoang.springmvc.simplebooking.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class TicketController {

    @GetMapping("/ticket")
    public String goToEventPage() {
        log.info("Going to ticket page");
        return "ticket";
    }
}
