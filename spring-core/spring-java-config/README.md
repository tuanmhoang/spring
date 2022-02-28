## Spring using Java configuration
Practicing Spring using Java configuration

### Reference:
**Spring - configure Java**

- https://docs.spring.io/spring-security/site/docs/5.0.x/reference/html/jc.html
 
**Example XML config**
- https://www.tutorialspoint.com/spring/spring_java_based_configuration.htm
- https://stackoverflow.com/questions/53114129/spring-constructor-injection-using-java-config

**Spring BeanPostProcessor init method annotation**
- https://stackoverflow.com/questions/5419695/init-method-in-spring-controller-annotation-version

**Constructor Injection**

In `ApplicationConfig.java`, define

```
    @Bean
    @Autowired
    public BookingFacade bookingFacade(EventService eventService, TicketService ticketService, UserService userService) {
        return new BookingFacadeImpl(eventService, ticketService, userService);
    }
```

In `BookingFacadeImpl.java` define

```
    private final EventService eventService;

    private final TicketService ticketService;

    private final UserService userService;

    @Autowired
    public BookingFacadeImpl(EventService eventService, TicketService ticketService, UserService userService) {
        this.eventService = eventService;
        this.ticketService = ticketService;
        this.userService = userService;
    }
```
