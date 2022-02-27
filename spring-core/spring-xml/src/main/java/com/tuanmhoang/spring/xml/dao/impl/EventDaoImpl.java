package com.tuanmhoang.spring.xml.dao.impl;

import com.tuanmhoang.spring.xml.dao.EventDao;
import com.tuanmhoang.spring.xml.data.EventDataService;
import com.tuanmhoang.spring.xml.entities.EventEntity;
import com.tuanmhoang.spring.xml.mapper.EventMapper;
import com.tuanmhoang.spring.xml.model.Event;
import com.tuanmhoang.spring.xml.model.impl.EventImpl;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class EventDaoImpl implements EventDao {

    private EventDataService eventData;

    private EventMapper eventMapper;

    public EventDaoImpl() {
    }

    public EventDaoImpl(EventDataService eventData, EventMapper eventMapper) {
        this.eventData = eventData;
        this.eventMapper = eventMapper;
    }

    @Override
    public List<Event> getByTitle(String title, int pageSize, int pageNum) {
        Map<Long, EventEntity> data = this.eventData.getData();
        return data.entrySet()
            .stream()
            .filter(e -> e.getValue().getTitle().equals(title))
            .map(e -> eventMapper.eventFromEventEntity(e.getValue()))
            .collect(Collectors.toList());
    }

    @Override
    public List<Event> getForDay(Date day, int pageSize, int pageNum) {
        Map<Long, EventEntity> data = this.eventData.getData();
        return data.entrySet()
            .stream()
            .filter(e->e.getValue().getDate().equals(day))
            .map(e -> eventMapper.eventFromEventEntity(e.getValue()))
            .collect(Collectors.toList());
    }

    @Override
    public Event create(Event event) {
        Map<Long, EventEntity> data = this.eventData.getData();

        Long newId = data.entrySet()
            .stream()
            .max(Comparator.comparing(e -> e.getKey()))
            .map(e -> e.getKey())
            .orElseThrow(NoSuchElementException::new) + 1;

        Event createdEvent = new EventImpl(
            newId,
            event.getTitle(),
            event.getDate()
        );

        data.put(newId, eventMapper.eventEntityFromEvent(createdEvent));

        return createdEvent;
    }

    @Override
    public Event update(Event event) {
        Map<Long, EventEntity> data = this.eventData.getData();
        data.put(event.getId(),eventMapper.eventEntityFromEvent(event));
        return event;
    }

    @Override
    public boolean delete(long id) {
        Map<Long, EventEntity> data = this.eventData.getData();
        if(data.containsKey(id)){
            data.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Event getById(long id) {
        final EventEntity eventEntity = eventData.getData().get(id);
        return eventMapper.eventFromEventEntity(eventEntity);
    }
}
