package com.tuanmhoang.springmvc.simplebooking.controller;

import com.tuanmhoang.springmvc.simplebooking.entity.Event;
import com.tuanmhoang.springmvc.simplebooking.entity.Ticket;
import com.tuanmhoang.springmvc.simplebooking.entity.User;
import com.tuanmhoang.springmvc.simplebooking.service.EventService;
import com.tuanmhoang.springmvc.simplebooking.service.TicketService;
import com.tuanmhoang.springmvc.simplebooking.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
@RequiredArgsConstructor
public class DefaultModelAttributeController {

    private final EventService eventService;

    private final UserService userService;

    private final TicketService ticketService;

    @ModelAttribute("users")
    public List<User> getDefaultUsers(){
        return userService.findAll();
    }

    @ModelAttribute("events")
    public List<Event> getDefaultEvents(){
        return eventService.findAll();
    }

    @ModelAttribute("tickets")
    public List<Ticket> getDefaultTickets(){
        return ticketService.findAll();
    }
}
