package com.tuanmhoang.spring.xml.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//@Slf4j
public class CustomBeanPostProcessor implements BeanPostProcessor {

//    private static Logger log = LoggerFactory.getLogger(CustomBeanPostProcessor.class);

    private static final Logger log = LogManager.getLogger(CustomBeanPostProcessor.class);

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("Called postProcessBeforeInitialization() for : {}", beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("Called postProcessAfterInitialization() for : {}", beanName);
        return bean;
    }
}
