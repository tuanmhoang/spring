package com.tuanmhoang.spring.xml.mapper;

import com.tuanmhoang.spring.xml.entities.EventEntity;
import com.tuanmhoang.spring.xml.model.Event;
import com.tuanmhoang.spring.xml.model.impl.EventImpl;

public interface EventMapper {
    EventEntity eventEntityFromEvent(Event event);
    Event eventFromEventEntity(EventEntity eventEntity);
}
