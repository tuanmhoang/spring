package com.tuanmhoang.spring.xml.dao;

import com.tuanmhoang.spring.xml.dao.impl.EventDaoImpl;
import com.tuanmhoang.spring.xml.data.EventData;
import com.tuanmhoang.spring.xml.entities.EventEntity;
import com.tuanmhoang.spring.xml.mapper.EventMapper;
import com.tuanmhoang.spring.xml.mockdata.MockDataUtils;
import com.tuanmhoang.spring.xml.model.Event;
import com.tuanmhoang.spring.xml.model.impl.EventImpl;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventDaoTest {

    @InjectMocks
    private EventDao eventDao = new EventDaoImpl();

    @Mock
    private EventData eventData;

    @Mock
    private EventMapper eventMapper;

    private Map<Long, EventEntity> mockData;

    @BeforeEach
    public void init() {
        mockData = MockDataUtils.mockEventData();
    }

    @Test
    public void givenId_whenGetById_thenReturnTheSearchedEvent() {
        final EventEntity foundEntity = mockData.get(1L);
        String expectedTitle = "Hackathon";
        Event expectedResult = new EventImpl(1L, expectedTitle, mockData.get(1L).getDate());
        when(eventData.getEventData()).thenReturn(mockData);
        when(eventMapper.eventFromEventEntity(nullable(EventEntity.class))).thenReturn(new EventImpl(
            foundEntity.getId(),
            foundEntity.getTitle(),
            foundEntity.getDate()
        ));

        Event event = eventDao.getById(1L);
        assertEquals(expectedResult.getId(), event.getId());
        assertEquals(expectedResult.getTitle(), event.getTitle());
        assertEquals(expectedResult.getDate(), event.getDate());
    }

    @Test
    public void givenAnEventInfo_whenCreate_ThenTheEventIsCreatedSuccessfully() {
        Date createdDate = new Date();
        Event eventToBeCreated = new EventImpl("Tech talk", createdDate);

        when(eventData.getEventData()).thenReturn(mockData);

        Event createdEvent = eventDao.create(eventToBeCreated);

        assertEquals(4, mockData.size());
        assertEquals(4, createdEvent.getId());
        assertEquals("Tech talk", createdEvent.getTitle());
        assertEquals(createdDate, createdEvent.getDate());
    }

    @Test
    public void givenTitleToBeSearched_whenCallGetByTitle_thenShouldReturnCorrectly() {
        String searchedTitle = "Hackathon";
        when(eventData.getEventData()).thenReturn(mockData);
        when(eventMapper.eventFromEventEntity(nullable(EventEntity.class))).thenReturn(new EventImpl(
            1L,
            searchedTitle,
            mockData.get(1L).getDate()
        ));
        final List<Event> searchedEvents = eventDao.getByTitle(searchedTitle, 10, 1);
        assertEquals(1, searchedEvents.size());
        assertEquals(1L, searchedEvents.get(0).getId());
        assertEquals(searchedTitle, searchedEvents.get(0).getTitle());
    }

    @Test
    public void givenIncorrectId_whenDeleteEvent_thenReturnFalse() {
        long idToDelete = 999L;
        when(eventData.getEventData()).thenReturn(mockData);
        assertFalse(eventDao.delete(idToDelete));
    }

    @Test
    public void givenCorrectId_whenDeleteEvent_thenReturnTrue() {
        long idToDelete = 1L;
        when(eventData.getEventData()).thenReturn(mockData);
        assertTrue(eventDao.delete(idToDelete));
        assertEquals(2, mockData.size());
        assertFalse(mockData.containsKey(1L));
    }

    @Test
    public void givenEventInfo_whenCallUpdate_thenDataShouldBeUpdated() {

        when(eventData.getEventData()).thenReturn(mockData);
        Event dataToUpdate = new EventImpl(1L, "Updated Title", mockData.get(1L).getDate());

        final Event updatedEvent = eventDao.update(dataToUpdate);

        assertEquals(1L, updatedEvent.getId());
        assertEquals("Updated Title", updatedEvent.getTitle());
    }
}
