package com.tuanmhoang.spring.xml.dao.impl;

import com.tuanmhoang.spring.xml.dao.TicketDao;
import com.tuanmhoang.spring.xml.data.TicketData;
import com.tuanmhoang.spring.xml.mapper.TicketMapper;

public class TicketDaoImpl implements TicketDao {

    private TicketData ticketData;

    private TicketMapper ticketMapper;

    public TicketDaoImpl(TicketData ticketData, TicketMapper ticketMapper) {
        this.ticketData = ticketData;
        this.ticketMapper = ticketMapper;
    }
}
