package com.tuanmhoang.springmvc.simplebooking.service;

import com.tuanmhoang.springmvc.simplebooking.entity.Event;
import com.tuanmhoang.springmvc.simplebooking.entity.Ticket;
import com.tuanmhoang.springmvc.simplebooking.entity.User;
import com.tuanmhoang.springmvc.simplebooking.model.enums.Category;
import java.util.List;

public interface TicketService {
    Ticket book(long userId, long eventId, int place, Category category);

    List<Ticket> getBookedTickets(User user, int pageSize, int pageNum);

    List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum);

    boolean cancel(long ticketId);

    List<Ticket> findAll();
}
