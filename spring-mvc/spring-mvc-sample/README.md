## Sample Spring MVC

### To setup

Need to define structure and implement `WebApplicationInitializer`

```
public class ApplicationInitializer implements WebApplicationInitializer
```

Then, need to extend `WebMvcConfigurationSupport`

```
public class ApplicationConfig extends WebMvcConfigurationSupport
```

In `ApplicationInitializer`, implement `onStartup`

```
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //bootstrap dispatcher servlet
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ApplicationConfig.class);

        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet(
            "mvc",
            new DispatcherServlet(context)
        );
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");
    }
```

And in `ApplicationConfig`, need to override the `addResourceHandlers` to tell spring to pick up resources

```
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) { 
        // tells spring to pickup resource at path
        registry.addResourceHandler("css/**", "images/**")
               .addResourceLocations("classpath:/css/", "classpath:/images/");
    }
```

and define `InternalResourceViewResolver` for the view

```
    @Bean
    public InternalResourceViewResolver jspViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }
```

Then, can use `mvn clean install` and run war file on Tomcat plugin

```
    <build>
        <plugins>
            <plugin>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.0.0</version>
            </plugin>
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.2</version>
                <configuration>
                    <port>8080</port>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

To run app, try http://localhost:8080/spring-mvc-sample/home

## Notes

### The versions may cause the problem

#### Spring MVC 5

Can consider to implement `WebMvcConfigurer `: https://stackoverflow.com/questions/14861720/annotation-configuration-replacement-for-mvcresources-spring

#### servlet-api.version

Version 3 cannot work with Tomcat7, consider to use https://plugins.jetbrains.com/plugin/9492-smart-tomcat with newer Tomcat version if use Intellij
