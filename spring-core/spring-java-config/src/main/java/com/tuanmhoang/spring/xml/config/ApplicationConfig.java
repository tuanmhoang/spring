package com.tuanmhoang.spring.xml.config;

import com.tuanmhoang.spring.xml.dao.EventDao;
import com.tuanmhoang.spring.xml.dao.TicketDao;
import com.tuanmhoang.spring.xml.dao.UserDao;
import com.tuanmhoang.spring.xml.dao.impl.EventDaoImpl;
import com.tuanmhoang.spring.xml.dao.impl.TicketDaoImpl;
import com.tuanmhoang.spring.xml.dao.impl.UserDaoImpl;
import com.tuanmhoang.spring.xml.data.EventDataService;
import com.tuanmhoang.spring.xml.data.TicketDataService;
import com.tuanmhoang.spring.xml.data.UserDataService;
import com.tuanmhoang.spring.xml.facade.BookingFacade;
import com.tuanmhoang.spring.xml.facade.impl.BookingFacadeImpl;
import com.tuanmhoang.spring.xml.mapper.EventMapper;
import com.tuanmhoang.spring.xml.mapper.TicketMapper;
import com.tuanmhoang.spring.xml.mapper.UserMapper;
import com.tuanmhoang.spring.xml.mapper.impl.EventMapperImpl;
import com.tuanmhoang.spring.xml.mapper.impl.TicketMapperImpl;
import com.tuanmhoang.spring.xml.mapper.impl.UserMapperImpl;
import com.tuanmhoang.spring.xml.model.Event;
import com.tuanmhoang.spring.xml.model.Ticket;
import com.tuanmhoang.spring.xml.model.User;
import com.tuanmhoang.spring.xml.model.impl.EventImpl;
import com.tuanmhoang.spring.xml.model.impl.TicketImpl;
import com.tuanmhoang.spring.xml.model.impl.UserImpl;
import com.tuanmhoang.spring.xml.service.EventService;
import com.tuanmhoang.spring.xml.service.TicketService;
import com.tuanmhoang.spring.xml.service.UserService;
import com.tuanmhoang.spring.xml.service.impl.EventServiceImpl;
import com.tuanmhoang.spring.xml.service.impl.TicketServiceImpl;
import com.tuanmhoang.spring.xml.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// Can also config the package to scan by using @ComponentScan
// @ComponentScan("com.tuanmhoang.spring.xml.config")
public class ApplicationConfig {

    @Bean(name = "eventData", initMethod = "init")
    public EventDataService eventDataService() {
        return new EventDataService();
    }

    @Bean(name = "userData", initMethod = "init")
    public UserDataService userDataService() {
        return new UserDataService();
    }

    @Bean(name = "ticketData", initMethod = "init")
    public TicketDataService ticketDataService() {
        return new TicketDataService();
    }

    @Bean
    public EventMapper eventMapper() {
        return new EventMapperImpl();
    }

    @Bean
    public TicketMapper ticketMapper() {
        return new TicketMapperImpl();
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

    @Bean
    @Autowired
    public EventDao eventDao(EventDataService eventData, EventMapper eventMapper) {
        return new EventDaoImpl(eventData, eventMapper);
    }

    @Bean
    @Autowired
    public TicketDao ticketDao(TicketDataService ticketData, TicketMapper ticketMapper) {
        return new TicketDaoImpl(ticketData, ticketMapper);
    }

    @Bean
    @Autowired
    public UserDao userDao(UserDataService userData, UserMapper userMapper) {
        return new UserDaoImpl(userData, userMapper);
    }

    @Bean
    public Event event() {
        return new EventImpl();
    }

    @Bean
    public Ticket ticket() {
        return new TicketImpl();
    }

    @Bean
    public User user() {
        return new UserImpl();
    }

    @Bean
    @Autowired
    public EventService eventService(EventDao eventDao) {
        return new EventServiceImpl(eventDao);
    }

    @Bean
    @Autowired
    public TicketService ticketService(TicketDao ticketDao) {
        return new TicketServiceImpl(ticketDao);
    }

    @Bean
    @Autowired
    public UserService userService(UserDao userDao) {
        return new UserServiceImpl(userDao);
    }

    @Bean
    @Autowired
    public BookingFacade bookingFacade(EventService eventService, TicketService ticketService, UserService userService) {
        return new BookingFacadeImpl(eventService, ticketService, userService);
    }
}
