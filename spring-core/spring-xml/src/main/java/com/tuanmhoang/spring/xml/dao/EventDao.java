package com.tuanmhoang.spring.xml.dao;

import com.tuanmhoang.spring.xml.model.Event;
import java.util.Date;
import java.util.List;

public interface EventDao {

    List<Event> getByTitle(String title, int pageSize, int pageNum);

    List<Event> getForDay(Date day, int pageSize, int pageNum);

    Event create(Event event);

    Event update(Event event);

    boolean delete(long id);

    Event getById(long id);
}
