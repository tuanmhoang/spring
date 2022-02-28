package com.tuanmhoang.spring.xml.integration;

import com.tuanmhoang.spring.xml.config.ApplicationConfig;
import com.tuanmhoang.spring.xml.data.EventDataService;
import com.tuanmhoang.spring.xml.entities.EventEntity;
import com.tuanmhoang.spring.xml.facade.BookingFacade;
import com.tuanmhoang.spring.xml.model.Event;
import com.tuanmhoang.spring.xml.model.impl.EventImpl;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class EventIntegrationTest {

    private Map<Long, EventEntity> eventData = new HashMap<>();

    private ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

    private BookingFacade bookingFacade = ctx.getBean(BookingFacade.class);

    private EventDataService eventDataService = ctx.getBean(EventDataService.class);

    @BeforeEach
    public void init() throws FileNotFoundException, ParseException {
        eventData = eventDataService.getData();
    }

    @Test
    public void givenEventId_whenGetById_shouldSuccess() {
        long idToGet = 2L;
        Date eventDate = eventData.get(2L).getDate();

        final Event eventGetById = bookingFacade.getEventById(2L);

        assertEquals(2L, eventGetById.getId());
        assertEquals("Hackathon", eventGetById.getTitle());
        assertEquals(eventDate, eventGetById.getDate());
    }

    @Test
    public void givenTitle_whenGetEventByTitle_thenReturnSuccessful() {
        String titleToSearch = "Hackathon";

        final List<Event> searchedEvents = bookingFacade.getEventsByTitle(titleToSearch, 10, 1);

        assertEquals(1, searchedEvents.size());
        assertEquals(2L, searchedEvents.get(0).getId());
        assertEquals("Hackathon", searchedEvents.get(0).getTitle());
    }

    @Test
    public void givenEventInfo_whenCreateEvent_thenShouldCreateSuccessful() {
        Date dateToCreate = new Date();
        Event eventToBeCreated = new EventImpl("New Event", dateToCreate);

        final Event createdEvent = bookingFacade.createEvent(eventToBeCreated);

        assertEquals(6L, createdEvent.getId());
        assertEquals("New Event", createdEvent.getTitle());
        assertEquals(dateToCreate, createdEvent.getDate());
    }

    @Test
    public void givenEventInfo_whenUpdateEvent_thenShouldUpdateSuccessful() {
        Date dateToUpdate = new Date();
        Event eventToBeUpdated = new EventImpl(1L, "Updated Event", dateToUpdate);

        final Event updatedEvent = bookingFacade.updateEvent(eventToBeUpdated);

        assertEquals(1L, updatedEvent.getId());
        assertEquals("Updated Event", updatedEvent.getTitle());
        assertEquals(dateToUpdate, updatedEvent.getDate());
    }

    @Test
    public void givenIncorrectEventId_whenUpdateEvent_thenShouldReturnFalse() {
        long idToDelete = 999L;
        final boolean result = bookingFacade.deleteEvent(idToDelete);
        assertFalse(result);
    }

    @Test
    public void givenIncorrectEventId_whenUpdateEvent_thenShouldReturnTrue() {
        long idToDelete = 1L;
        final boolean result = bookingFacade.deleteEvent(idToDelete);
        assertTrue(result);
        assertEquals(4,eventData.size());
        assertFalse(eventData.containsKey(idToDelete));
    }
}
