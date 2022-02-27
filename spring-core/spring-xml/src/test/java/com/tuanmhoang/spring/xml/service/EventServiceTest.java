package com.tuanmhoang.spring.xml.service;

import com.tuanmhoang.spring.xml.dao.EventDao;
import com.tuanmhoang.spring.xml.entities.EventEntity;
import com.tuanmhoang.spring.xml.entities.UserEntity;
import com.tuanmhoang.spring.xml.mockdata.MockDataUtils;
import com.tuanmhoang.spring.xml.model.Event;
import com.tuanmhoang.spring.xml.model.impl.EventImpl;
import com.tuanmhoang.spring.xml.service.impl.EventServiceImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventServiceTest {

    @InjectMocks
    private EventService eventService = new EventServiceImpl();

    @Mock
    private EventDao eventDao;

    private Map<Long, EventEntity> data = new HashMap<>();

    @BeforeEach
    public void init() {
        data = MockDataUtils.createMockEventData();
    }

    @Test
    public void givenEventId_whenGetById_thenShouldReturnCorrectly() {
        long idToGet = 1L;
        Event returnedByEventDao = new EventImpl(1L, "Hackathon", data.get(1L).getDate());

        when(eventDao.getById(idToGet)).thenReturn(returnedByEventDao);

        final Event searchedEvent = eventService.getById(idToGet);

        assertEquals(1L, searchedEvent.getId());
        assertEquals("Hackathon", searchedEvent.getTitle());
        assertEquals(data.get(1L).getDate(), searchedEvent.getDate());
    }

    @Test
    public void givenTitlePageSizeAndPageNum_whenGetByTitle_thenShouldReturnListOfEvents() {
        String searchedTitle = "Team building";
        int pageSize = 10;
        int pageNum = 1;

        List<Event> returnedByEventDao = new ArrayList<>();
        Event mockEvent = new EventImpl(3L, "Team building", data.get(3L).getDate());
        returnedByEventDao.add(mockEvent);
        when(eventDao.getByTitle(searchedTitle, pageSize, pageNum)).thenReturn(returnedByEventDao);

        final List<Event> searchedEvents = eventService.getByTitle(searchedTitle, pageSize, pageNum);
        assertEquals(1, searchedEvents.size());
        assertEquals(3L, searchedEvents.get(0).getId());
        assertEquals("Team building", searchedEvents.get(0).getTitle());
        assertEquals(data.get(3L).getDate(), searchedEvents.get(0).getDate());

    }

    @Test
    public void givenAnEventInfo_whenCreate_shouldSuccess() {
        Date dateToCreate = new Date();
        Event eventToBeCreated = new EventImpl(4L, "Tech talk", dateToCreate);

        when(eventDao.create(eventToBeCreated)).thenReturn(eventToBeCreated);

        final Event createdEvent = eventService.create(eventToBeCreated);

        assertEquals(4L, createdEvent.getId());
        assertEquals("Tech talk", createdEvent.getTitle());
        assertEquals(dateToCreate, createdEvent.getDate());
    }

    @Test
    public void givenAnEventToUpdate_whenUpdate_thenShouldSuccessful() {
        Date updatedDay = new Date();
        String titleToUpdate = "Updated event title";
        Event eventToUpdate = new EventImpl(2L, titleToUpdate, updatedDay);
        Event mockEventUpdatedByEventDao = new EventImpl(2L, titleToUpdate, updatedDay);

        when(eventDao.update(eventToUpdate)).thenReturn(mockEventUpdatedByEventDao);

        final Event updatedEvent = eventService.updateEvent(eventToUpdate);

        assertEquals(2L, updatedEvent.getId());
        assertEquals(titleToUpdate, updatedEvent.getTitle());
        assertEquals(updatedDay, updatedEvent.getDate());
    }

    @Test
    public void givenIdToDelete_whenDelete_thenShouldReturnTrue() {
        long idToDelete = 1L;

        when(eventDao.delete(idToDelete)).thenReturn(true);

        final boolean deleteResult = eventService.delete(idToDelete);
        assertTrue(deleteResult);
    }

    @Test
    public void givenIdToDelete_whenDelete_thenShouldReturnFalse() {
        long idToDelete = 1L;

        when(eventDao.delete(idToDelete)).thenReturn(false);

        final boolean deleteResult = eventService.delete(idToDelete);
        assertFalse(deleteResult);
    }
}
