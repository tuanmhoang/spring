package com.tuanmhoang.spring.xml;

import com.google.gson.Gson;
import com.tuanmhoang.spring.xml.facade.BookingFacade;
import com.tuanmhoang.spring.xml.model.Event;
import com.tuanmhoang.spring.xml.model.impl.EventImpl;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@Slf4j
public class SpringXmlApplication {

    //private static Logger log = LoggerFactory.getLogger(SpringXmlApplication.class);

    private static final Logger log = LogManager.getLogger(SpringXmlApplication.class);

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans/beans.xml");
        Event event = ctx.getBean(Event.class);
//        Ticket ticket = ctx.getBean(Ticket.class);
//        User user = ctx.getBean(User.class);

        BookingFacade bookingFacade = ctx.getBean(BookingFacade.class);
        Gson gson = new Gson();

        log.info("============================== {} ==============================", "Event");
        log.info("==== findById ====");
        final Event eventById = bookingFacade.getEventById(1L);
        log.info("[*] Get by id = 1: {} ", gson.toJson(eventById));

        log.info("==== create new ====");
        Event eventToBeCreated = new EventImpl("New Event", new Date());
        Event createdEvent = bookingFacade.createEvent(eventToBeCreated);
        log.info("[*] Created event: {} ", gson.toJson(createdEvent));

        log.info("==== update incorrect id ====");
        long idToUpdate = 6L;
        Event eventToBeUpdated = new EventImpl(idToUpdate,"Updated Title", new Date());
        log.info("[*] Update result: {}", gson.toJson(bookingFacade.updateEvent(eventToBeUpdated)));
        log.info("[*] Get by id {} result: {}", idToUpdate, gson.toJson(bookingFacade.getEventById(idToUpdate)));

        log.info("==== find by title ====");
        String titleToSearch = "Hackathon";
        bookingFacade.getEventsByTitle(titleToSearch, 10,1);
        log.info("[*] With title is {}, result: {}", titleToSearch, gson.toJson(bookingFacade.getEventsByTitle("Hackathon", 10,1)));

        log.info("==== delete ====");
        long idToDelete = 999L; // not exist ID
        log.info("[*] Delete ID {},  result: {}", idToDelete, bookingFacade.deleteEvent(idToDelete));
        idToDelete = 6L; // exists ID
        log.info("[*] Delete ID {},  result: {}", idToDelete, bookingFacade.deleteEvent(idToDelete));

        // close the context
        if ((ctx instanceof ConfigurableApplicationContext)) {
            ((ConfigurableApplicationContext)ctx).close();
        }

    }
}
