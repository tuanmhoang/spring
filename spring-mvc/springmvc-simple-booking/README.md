### Get properties

- Reference: https://stackoverflow.com/questions/30528255/how-to-access-a-value-defined-in-the-application-properties-file-in-spring-boot

Can use `@PropertySource("classpath:application.properties")` 

then call

```
    @Value("${abctest}")
    private String valueFromFile;
```

### Config h2

Reference:
- https://stackoverflow.com/questions/38040572/spring-boot-loading-initial-data
- https://www.javacodegeeks.com/2017/12/configure-embedded-h2-console-spring-mvc-application.html

To add more config: https://stackoverflow.com/questions/9353167/auto-increment-id-in-h2-database

## Problems and solutions

### Problem

Database "C:/Users/Tuan_Hoang/test" not found, either pre-create it or allow remote database creation (not recommended in secure environments) [90149-210] 90149/90149

Reference: https://stackoverflow.com/questions/61865206/springboot-2-3-0-while-connecting-to-h2-database

**Solution**

Create `test.mv.db`

**Repository**

```
org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.tuanmhoang.springmvc.simplebooking.repository.EventRepository' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}
```

**Solution**

Use 

```
@EnableJpaRepositories(basePackages = "com.tuanmhoang.springmvc.simplebooking.repository")
```

```
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'eventRepository' defined in com.tuanmhoang.springmvc.simplebooking.repository.EventRepository defined in @EnableJpaRepositories declared on ApplicationConfig: Cannot create inner bean '(inner bean)#50a2376' of type [org.springframework.orm.jpa.SharedEntityManagerCreator] while setting bean property 'entityManager'; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name '(inner bean)#50a2376': Cannot resolve reference to bean 'entityManagerFactory' while setting constructor argument; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'entityManagerFactory' available
```

Reference: https://stackoverflow.com/questions/24520602/spring-data-jpa-no-bean-named-entitymanagerfactory-is-defined-injection-of-a

```
java.lang.IllegalArgumentException: Not a managed type: class com.tuanmhoang.springmvc.simplebooking.entity.Event
```
Reason: it should be scanned with correct package

Reference: https://stackoverflow.com/questions/28664064/spring-boot-not-a-managed-type

Correct setup

```
factory.setPackagesToScan("com.tuanmhoang.springmvc.simplebooking.entity"); // entity package
```

JSP page displays

```
Username: ${user.name} - Email: ${user.email}
```

Reason: https://mkyong.com/spring-mvc/modelandviews-model-value-is-not-displayed-in-jsp-via-el/

> The EL is disabled or ignored by default, you have to enable it manually, so that it will outputs the value store in the “msg” model.

To fix, add

```
<%@ page isELIgnored="false" %>
```

```
No bean named 'transactionManager' available
```

To fix: https://stackoverflow.com/questions/48861439/no-bean-named-transactionmanager-available

```
org.h2.jdbc.JdbcSQLDataException: Data conversion error converting "CHARACTER LARGE OBJECT to INTEGER" [22018-210]
```

Reference: https://github.com/h2database/h2database/issues/3444

