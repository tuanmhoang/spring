package com.tuanmhoang.spring.xml.service.impl;

import com.tuanmhoang.spring.xml.dao.TicketDao;
import com.tuanmhoang.spring.xml.model.Event;
import com.tuanmhoang.spring.xml.model.Ticket;
import com.tuanmhoang.spring.xml.model.User;
import com.tuanmhoang.spring.xml.model.enums.Category;
import com.tuanmhoang.spring.xml.service.TicketService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketDao ticketDao;

    @Autowired
    public TicketServiceImpl(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public Ticket book(long userId, long eventId, int place, Category category) {
        return null;
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public boolean cancel(long ticketId) {
        return false;
    }
}
