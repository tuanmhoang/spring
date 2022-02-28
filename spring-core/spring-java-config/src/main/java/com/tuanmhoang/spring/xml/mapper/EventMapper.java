package com.tuanmhoang.spring.xml.mapper;

import com.tuanmhoang.spring.xml.entities.EventEntity;
import com.tuanmhoang.spring.xml.model.Event;

public interface EventMapper {
    EventEntity eventEntityFromEvent(Event event);
    Event eventFromEventEntity(EventEntity eventEntity);
}
