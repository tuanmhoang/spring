package com.tuanmhoang.springmvc.simplebooking.service.impl;

import com.tuanmhoang.springmvc.simplebooking.entity.Event;
import com.tuanmhoang.springmvc.simplebooking.repository.EventRepository;
import com.tuanmhoang.springmvc.simplebooking.service.EventService;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public Event getById(long eventId) {
        return eventRepository.findById(eventId).get();
    }

    @Override
    public List<Event> getByTitle(String title, int pageSize, int pageNum) {
        return eventRepository.findByTitle(title);
    }

    @Override
    public List<Event> getForDay(Date day, int pageSize, int pageNum) {
        return eventRepository.findByDate(day);
    }

    @Override
    public Event create(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void delete(long eventId) {
        eventRepository.delete(getById(eventId));
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }
}
