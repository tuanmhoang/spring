package com.tuanmhoang.springmvc.simplebooking.controller;

import com.tuanmhoang.springmvc.simplebooking.entity.Event;
import com.tuanmhoang.springmvc.simplebooking.entity.Ticket;
import com.tuanmhoang.springmvc.simplebooking.entity.User;
import com.tuanmhoang.springmvc.simplebooking.model.enums.Category;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@PropertySource("classpath:application.properties")
public class HomeController {

    @Value("${abctest}")
    private String valueFromFile;

    @GetMapping("/home")
    public String goHome(Model model) {
        log.info("log - valueFromFile: {}", valueFromFile);

//        List<User> users = new ArrayList<>();
//        users.add(new User(1L, "Alice", "alice@email.com"));
//        users.add(new User(2L, "Bob", "bob@email.com"));
//
//        List<Event> events = new ArrayList<>();
//        events.add(new Event(1L, "Tech talk", LocalDate.of(2022, 1, 8)));
//        events.add(new Event(2L, "Company trip", LocalDate.of(2022, 2, 18)));
//
//        List<Ticket> tickets = new ArrayList<>();
//        tickets.add(new Ticket(1L, 1L, 1L, Category.PREMIUM,1));
//        tickets.add(new Ticket(2L, 2L, 2L, Category.STANDARD,2));
//
//        model.addAttribute("users",users);
//        model.addAttribute("events",events);
//        model.addAttribute("teststring", "dm jsp");
//
//
//        ////
//        List<String> empList = new ArrayList<>();
//        empList.add("aaa");
//        empList.add("bbb");
//        empList.add("ccc");
//        model.addAttribute("empList", empList);

        return "index";
    }

//    @GetMapping("/home")
//    public ModelAndView goHome() {
//        log.info("log - valueFromFile: {}", valueFromFile);
//
//        List<User> users = new ArrayList<>();
//        users.add(new User(1L, "Alice", "alice@email.com"));
//        users.add(new User(2L, "Bob", "bob@email.com"));
//
//        List<Event> events = new ArrayList<>();
//        events.add(new Event(1L, "Tech talk", LocalDate.of(2022, 1, 8)));
//        events.add(new Event(2L, "Company trip", LocalDate.of(2022, 2, 18)));
//
//        List<Ticket> tickets = new ArrayList<>();
//        tickets.add(new Ticket(1L, 1L, 1L, Category.PREMIUM,1));
//        tickets.add(new Ticket(2L, 2L, 2L, Category.STANDARD,2));
//
//
//        //return back to index.jsp
//        ModelAndView model = new ModelAndView("index");
//        model.addObject("users", users);
//        model.addObject("events", events);
//
//        return model;
//
//    }
}