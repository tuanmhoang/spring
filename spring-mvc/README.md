## Spring MVC

### Basic configuration

- Spring MVC: spring-mvc-sample
- Springboot web: springboot-mvc-sample

### Notes

#### Java and JSP

Use `@ModelAttribute` to map between Java and JSP

#### Validations

Can use some annotations such as
- `@NotNull`
- `@NotEmpty`
- `@Size`
- `@Pattern`
- etc.

Spring tag for error

`<form:errors path="..."></form>`

**Binders** 

To extract and bind request data to Java object. Example

```
@InitBinder
public void initBinder(WebDataBinder binder){
    binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDataEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
}
```

***Converter*

To convert data. 

```
public class StringToEnumConverter implements Converter<String, Gender>{
    @Override
    public Gender convert(String s){
        // logic
        return ...;
    }
}
```

To register converter

```
public class ApplicationConfig implements WebMvcConfigurer{
    // other code

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(StringToEnumConverter.class);
    }
}
```

To persist to db using String

```
@Enumurated(EnumType.STRING)
private Gender gender;
```

Some special bean types
- HandlerMapping: map request to handler
- HandlerAdapter: invokes the handler
- HandlerExceptionResolver: helps exception handling
- ViewResolver: helps resolve views
- LocaleResolver: helps l10n and l18n support
- ThemeResolver: helps stylized look and feel

**Handle exception**

Use `@ExceptionHandler` and `@ControllerAdvice`

Can use `@ControllerAdvice` for default ModelAttribute

**Async**

Can set config

```
    @Override
    protected void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(5000);
        configurer.setTaskExecutor(mvcTaskExecutor());
    }

    @Bean
    public AsyncTaskExecutor mvcTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("hplusapp-thread-");
        return threadPoolTaskExecutor;

    }
```

**@Async vs DeferredResult vs Callable**

Reference: https://stackoverflow.com/questions/17855852/difference-between-spring-mvcs-async-deferredresult-and-callable


**Interceptor**

Add interceptor class

```
public class LoggingInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       //get all cookies
        //log session id:
        //log the request path

        String sessionId = null;

        if(null!=request.getCookies()){
            for(Cookie cookie: request.getCookies()){
                if("JSESSIONID".equals(cookie.getName())){
                    sessionId = cookie.getValue();
                }
            }
        }

        System.out.println("Incoming request data log: session: "+sessionId+
                " at "+ new Date()+" for "+request.getRequestURI());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("in post handle");
    }
}
```

Register interceptor

```
public class ApplicationConfig extends WebMvcConfigurationSupport {    

    // ...

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingInterceptor()).addPathPatterns("/*");
    }
}
```

**Session Attribute**

Define in controller

```
@Controller
@SessionAttributes("login")
public class LoginController() {
    // ...
}
```

Define a `@Bean` or in `@ControllerAdvice`

```
@ControllerAdvice
public class DefaultModelAttributeController {
    
    //....

    @ModelAttribute("login")
    public Login getDefaultLogin(){
        return new Login();
    }
}
```

Define in JSP

```
<form:form action="/login" method="post" modelAttribute="login">
	<label>Username</label> <form:input type="text" path="username"/><br />
	<label>Password</label> <form:input type="password" path="password"/><br />
	<input type="submit" value="Login">
</form:form>
```

Get SessionAttribute

```
@Controller
public class UserProfileController {

    @PostMapping("/userprofile")
    public String getUserProfile(@SessionAttribute("login")Login login, Model model){
        System.out.println("in user profile controller");
        System.out.println("username from session: "+login.getUsername());
        //call to userrepository to get all the user information
        model.addAttribute("username", login.getUsername());
        return "profile";
    }
}
```

**End HttpSession**

```
@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpSession session){
        System.out.println("Ending user session");
        session.invalidate();
        //System.out.println(session.getAttribute("login"));
        return "login";
    }
}
```