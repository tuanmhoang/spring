package com.tuanmhoang.spring.xml.service.impl;

import com.tuanmhoang.spring.xml.dao.EventDao;
import com.tuanmhoang.spring.xml.mapper.EventMapper;
import com.tuanmhoang.spring.xml.model.Event;
import com.tuanmhoang.spring.xml.service.EventService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    private EventDao eventDao;

    public EventServiceImpl() {
    }

    @Autowired
    public EventServiceImpl(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public Event getById(long id) {
        return eventDao.getById(id);
    }

    @Override
    public List<Event> getByTitle(String title, int pageSize, int pageNum) {
        return eventDao.getByTitle( title,  pageSize,  pageNum);
    }

    @Override
    public List<Event> getForDay(Date day, int pageSize, int pageNum) {
        return eventDao.getForDay( day,  pageSize,  pageNum) ;
    }

    @Override
    public Event create(Event event) {
        return eventDao.create(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventDao.update(event);
    }

    @Override
    public boolean delete(long id) {
        return eventDao.delete(id);
    }
}
