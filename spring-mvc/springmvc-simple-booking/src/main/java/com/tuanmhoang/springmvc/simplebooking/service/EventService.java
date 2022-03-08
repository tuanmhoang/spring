package com.tuanmhoang.springmvc.simplebooking.service;

import com.tuanmhoang.springmvc.simplebooking.entity.Event;
import java.util.Date;
import java.util.List;

public interface EventService {
    Event getById(long eventId);

    List<Event> getByTitle(String title, int pageSize, int pageNum);

    List<Event> getForDay(Date day, int pageSize, int pageNum);

    Event create(Event event);

    Event updateEvent(Event event);

    void delete(long eventId);

    List<Event> findAll();
}
