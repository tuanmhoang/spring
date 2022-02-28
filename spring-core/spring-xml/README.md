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

**Use p-namespace**

Reference: https://examples.javacodegeeks.com/enterprise-java/spring/spring-p-namespace-example/

Add

```
xmlns:p="http://www.springframework.org/schema/p"
```

**Config Slf4j for Spring**

Reference: https://stackoverflow.com/questions/3387441/how-do-i-configure-spring-and-slf4j-so-that-i-can-get-logging

**Notice**

- Reference: https://docs.spring.io/spring-framework/docs/4.3.7.RELEASE_to_4.3.8.RELEASE/Spring%20Framework%204.3.8.RELEASE/org/springframework/util/Log4jConfigurer.html

>Class Log4jConfigurer
> 
>java.lang.Object
org.springframework.util.Log4jConfigurer
> 
>Deprecated.
> 
>as of Spring 4.2.1, in favor of Apache Log4j 2 (following Apache's EOL declaration for log4j 1.x)

Reference: 
- https://stackoverflow.com/questions/48107537/log4jconfigurer-in-spring-5-0-2
- https://yiingw.wordpress.com/2017/12/12/log4j2-tips-standalone/
- https://logging.apache.org/log4j/2.x/maven-artifacts.html

**To use Spring namespace**

- p-namespace: https://examples.javacodegeeks.com/enterprise-java/spring/spring-p-namespace-example/
- util-namespace: https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/xsd-config.html

Add

```
xmlns:p="http://www.springframework.org/schema/p"
xmlns:util="http://www.springframework.org/schema/util"
```

And 

```
http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd
```

Before applying `p-namespace` and `util-namespace`

```
        <bean id="log4jConfigurer" class="org.springframework.beans.factory.config.MethodInvokingFactoryBean">
            <property name="targetClass" value="org.apache.logging.log4j.LogManager"/>
            <property name="targetMethod" value="getContext"/>
            <property name="arguments">
                <list>
                    <value>false</value>
                </list>
            </property>
        </bean>
```

After applying 

```
    <util:list id="arg-list-configurer" list-class="java.util.ArrayList">
        <value>false</value>
    </util:list>

    <bean id="log4jConfigurer" class="org.springframework.beans.factory.config.MethodInvokingFactoryBean"
        p:targetClass="org.apache.logging.log4j.LogManager"
        p:targetMethod="getContext"
        p:arguments-ref="arg-list-configurer"/>
```



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

**Problem 5**

In IDE

```
URI is not registered (Settings | Languages & Frameworks | Schemas and DTDs)
```

**Solution**

Reference: 
- https://stackoverflow.com/questions/42569634/uri-is-not-registered-settings-languages-frameworks-schemas-and-dtds-in
- https://stackoverflow.com/questions/13012300/error-with-p-schema-url/46510169

**Problem 6**

```
SLF4J: Class path contains multiple SLF4J bindings
```

**Solutions**

Reference: https://stackoverflow.com/questions/14024756/slf4j-class-path-contains-multiple-slf4j-bindings

> Noticed that the conflict comes from two jars, named `logback-classic-1.2.3` and `log4j-slf4j-impl-2.8.2.jar`