package com.tuanmhoang.spring.xml.mapper;

import com.tuanmhoang.spring.xml.entities.TicketEntity;
import com.tuanmhoang.spring.xml.model.Ticket;

public interface TicketMapper {
    TicketEntity ticketEntityFromTicket(Ticket ticket);
    Ticket ticketFromTicketEntity(TicketEntity ticketEntity);
}
