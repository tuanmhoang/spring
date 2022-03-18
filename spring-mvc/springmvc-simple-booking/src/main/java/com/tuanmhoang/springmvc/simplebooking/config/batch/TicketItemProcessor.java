package com.tuanmhoang.springmvc.simplebooking.config.batch;

import com.tuanmhoang.springmvc.simplebooking.model.TicketDto;
import org.springframework.batch.item.ItemProcessor;

public class TicketItemProcessor implements ItemProcessor<TicketDto, TicketDto> {

    @Override
    public TicketDto process(TicketDto ticketDto) throws Exception {
        return ticketDto;
    }
}
