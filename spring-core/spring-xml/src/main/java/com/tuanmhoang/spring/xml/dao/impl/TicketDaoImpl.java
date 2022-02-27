package com.tuanmhoang.spring.xml.dao.impl;

import com.tuanmhoang.spring.xml.dao.TicketDao;
import com.tuanmhoang.spring.xml.data.TicketDataService;
import com.tuanmhoang.spring.xml.mapper.TicketMapper;

public class TicketDaoImpl implements TicketDao {

    private TicketDataService ticketData;

    private TicketMapper ticketMapper;

    public TicketDaoImpl(TicketDataService ticketData, TicketMapper ticketMapper) {
        this.ticketData = ticketData;
        this.ticketMapper = ticketMapper;
    }
}
