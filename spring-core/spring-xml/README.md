## Spring using XML configuration
Practicing Spring using XML configuration

### Reference:
**Spring - configure XML**

- https://docs.spring.io/spring-framework/docs/5.0.0.M5/spring-framework-reference/htmlsingle/#xsd-configuration
 
**Example XML config**
- https://howtodoinjava.com/spring5/core/spring-bean-xml-config/
- https://java2blog.com/spring-xml-configuration/

**Spring BeanPostProcessor**
- https://stackoverflow.com/questions/29743320/how-exactly-does-the-spring-beanpostprocessor-work

**Spring BeanPostProcessor vs init/destroy method**
- https://stackoverflow.com/questions/9862127/what-is-the-difference-between-beanpostprocessor-and-init-destroy-method-in-spri

**Spring bean lifecycle**

- https://reflectoring.io/spring-bean-lifecycle/

**Constructor Injection**

In `beans.xml`, define
```
    <bean id="bookingFacade" class="com.tuanmhoang.spring.xml.facade.impl.BookingFacadeImpl">
        <constructor-arg index="0" ref="eventService"/>
        <constructor-arg index="1" ref="ticketService"/>
        <constructor-arg index="2" ref="userService"/>
    </bean>
```

In `BookingFacadeImpl` add constructor

```
    private EventService eventService;

    private TicketService ticketService;

    private UserService userService;

    public BookingFacadeImpl(EventService eventService, TicketService ticketService, UserService userService) {
        this.eventService = eventService;
        this.ticketService = ticketService;
        this.userService = userService;
    }
```

Since the purpose is to practice with Spring XML configuration, I would skip implementing for `User` and `Ticket`

### Problems and solutions

#### Problem 1
```
Cannot resolve symbol 'http://www.springframework.org/schema/beans/spring-beans.xsd'
```

**Solution**

Add
```
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
```

#### Problem 2

Spring cannot find bean xml configuration file when it does exist

**Solution**

https://stackoverflow.com/questions/12893760/spring-cannot-find-bean-xml-configuration-file-when-it-does-exist

Add correct path, in the project, use

```
ApplicationContext ctx = new ClassPathXmlApplicationContext("beans/beans.xml");
```
**Problem 3**

```
Failed to instantiate [com.tuanmhoang.spring.xml.model.Event]: Specified class is an interface
```

**Solution**

Reference: https://stackoverflow.com/questions/30795617/instantiation-of-bean-failed-specified-class-is-an-interface

Mapping to interface is incorrect. Should map to implementation.

Incorrect configuration

```
<bean id="event" class="com.tuanmhoang.spring.xml.model.Event"></bean>
```

Correct configuration

```
<bean id="event" class="com.tuanmhoang.spring.xml.model.impl.EventImpl"></bean>
```

**Problem 4**

```
Cannot instantiate @InjectMocks field named 'eventDao'! Cause: the type 'EventDao' is an interface.
```

**Solution**

Reference: https://www.javacodegeeks.com/2020/07/mockito-cannot-instantiate-injectmocks-field-the-type-is-an-interface.html

Current code

```
    @InjectMocks
    private EventDao eventDao;
```

Should be

```
    @InjectMocks
    private EventDao eventDao = new EventDaoImpl();
```