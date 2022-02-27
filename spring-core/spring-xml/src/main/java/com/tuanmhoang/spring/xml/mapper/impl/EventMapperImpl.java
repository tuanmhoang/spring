package com.tuanmhoang.spring.xml.mapper.impl;

import com.tuanmhoang.spring.xml.entities.EventEntity;
import com.tuanmhoang.spring.xml.mapper.EventMapper;
import com.tuanmhoang.spring.xml.model.Event;
import com.tuanmhoang.spring.xml.model.impl.EventImpl;

public class EventMapperImpl implements EventMapper {

    @Override
    public EventEntity eventEntityFromEvent(Event event) {
        return new EventEntity(event.getId(), event.getTitle(), event.getDate());
    }

    @Override
    public Event eventFromEventEntity(EventEntity eventEntity) {
        return new EventImpl(eventEntity.getId(),eventEntity.getTitle(),eventEntity.getDate());
    }
}
