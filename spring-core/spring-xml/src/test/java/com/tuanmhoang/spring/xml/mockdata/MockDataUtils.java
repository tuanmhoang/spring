package com.tuanmhoang.spring.xml.mockdata;

import com.tuanmhoang.spring.xml.entities.EventEntity;
import com.tuanmhoang.spring.xml.entities.UserEntity;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MockDataUtils {

    public static Map<Long, EventEntity> createMockEventData() {
        Map<Long, EventEntity> mockData = new HashMap<>();
        mockData.put(1L, createMockEventEntity(1L, "Hackathon", new Date()));
        mockData.put(2L, createMockEventEntity(2L, "Company trip", new Date()));
        mockData.put(3L, createMockEventEntity(3L, "Team building", new Date()));
        return mockData;
    }

    private static EventEntity createMockEventEntity(Long id, String title, Date date) {
        return new EventEntity(id, title, date);
    }
}
