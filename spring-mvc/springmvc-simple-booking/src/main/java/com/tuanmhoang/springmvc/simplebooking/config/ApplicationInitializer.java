package com.tuanmhoang.springmvc.simplebooking.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.h2.server.web.WebServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer {

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

        ServletRegistration.Dynamic h2ServletRegistration = servletContext.addServlet(
            "h2-console",
            new WebServlet()
        );
        h2ServletRegistration.setLoadOnStartup(1);
        h2ServletRegistration.addMapping("/console/*");
    }
}
