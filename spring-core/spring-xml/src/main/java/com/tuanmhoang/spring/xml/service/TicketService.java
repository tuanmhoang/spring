package com.tuanmhoang.spring.xml.service;

import com.tuanmhoang.spring.xml.model.Event;
import com.tuanmhoang.spring.xml.model.Ticket;
import com.tuanmhoang.spring.xml.model.User;
import com.tuanmhoang.spring.xml.model.enums.Category;
import java.util.List;

public interface TicketService {
    Ticket book(long userId, long eventId, int place, Category category);

    List<Ticket> getBookedTickets(User user, int pageSize, int pageNum);

    List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum);

    boolean cancel(long ticketId);
}
