package com.tuanmhoang.spring.xml.dao.impl;

import com.tuanmhoang.spring.xml.dao.TicketDao;
import com.tuanmhoang.spring.xml.data.TicketDataService;
import com.tuanmhoang.spring.xml.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl implements TicketDao {

    private TicketDataService ticketData;

    private TicketMapper ticketMapper;

    @Autowired
    public TicketDaoImpl(TicketDataService ticketData, TicketMapper ticketMapper) {
        this.ticketData = ticketData;
        this.ticketMapper = ticketMapper;
    }
}
