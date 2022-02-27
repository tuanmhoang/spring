package com.tuanmhoang.spring.xml.mapper.impl;

import com.tuanmhoang.spring.xml.entities.TicketEntity;
import com.tuanmhoang.spring.xml.mapper.TicketMapper;
import com.tuanmhoang.spring.xml.model.Ticket;
import com.tuanmhoang.spring.xml.model.impl.TicketImpl;

public class TicketMapperImpl implements TicketMapper {
    @Override
    public TicketEntity ticketEntityFromTicket(Ticket ticket) {
        return new TicketEntity(
            ticket.getId(),
            ticket.getEventId(),
            ticket.getUserId(),
            ticket.getCategory(),
            ticket.getPlace()
        );
    }

    @Override
    public Ticket ticketFromTicketEntity(TicketEntity ticketEntity) {
        return new TicketImpl(
            ticketEntity.getId(),
            ticketEntity.getEventId(),
            ticketEntity.getUserId(),
            ticketEntity.getCategory(),
            ticketEntity.getPlace()
        );
    }
}
