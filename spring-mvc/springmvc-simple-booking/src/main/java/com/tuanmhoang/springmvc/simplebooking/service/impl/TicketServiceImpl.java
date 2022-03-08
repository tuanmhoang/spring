package com.tuanmhoang.springmvc.simplebooking.service.impl;

import com.tuanmhoang.springmvc.simplebooking.entity.Event;
import com.tuanmhoang.springmvc.simplebooking.entity.Ticket;
import com.tuanmhoang.springmvc.simplebooking.entity.User;
import com.tuanmhoang.springmvc.simplebooking.model.enums.Category;
import com.tuanmhoang.springmvc.simplebooking.repository.TicketRepository;
import com.tuanmhoang.springmvc.simplebooking.service.TicketService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

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

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }
}
