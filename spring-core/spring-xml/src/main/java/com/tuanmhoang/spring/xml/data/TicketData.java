package com.tuanmhoang.spring.xml.data;

import com.tuanmhoang.spring.xml.entities.TicketEntity;
import com.tuanmhoang.spring.xml.model.enums.Category;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketData {

    private Map<Long, TicketEntity> ticketData = new HashMap<>();

    public void init() {
        ticketData.put(1L, createTicketData(1L, 1L, 1L, Category.STANDARD, 1));
        ticketData.put(2L, createTicketData(2L, 1L, 2L, Category.PREMIUM, 1));
        ticketData.put(3L, createTicketData(3L, 2L, 3L, Category.STANDARD, 1));
        ticketData.put(4L, createTicketData(4L, 2L, 4L, Category.STANDARD, 1));
        ticketData.put(5L, createTicketData(5L, 3L, 5L, Category.BAR, 1));
        ticketData.put(6L, createTicketData(6L, 3L, 6L, Category.BAR, 1));
        ticketData.put(7L, createTicketData(7L, 4L, 7L, Category.STANDARD, 1));
        ticketData.put(8L, createTicketData(8L, 5L, 8L, Category.PREMIUM, 1));
        ticketData.put(9L, createTicketData(9L, 5L, 9L, Category.PREMIUM, 1));
        ticketData.put(10L, createTicketData(10L, 5L, 10L, Category.STANDARD, 1));
    }

    private TicketEntity createTicketData(long id, long eventId, long userId, Category category, int place) {
        return new TicketEntity(id, eventId, userId, category, place);
    }
}
