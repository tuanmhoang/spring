package com.tuanmhoang.springmvc.simplebooking.controller;

import com.tuanmhoang.springmvc.simplebooking.restcontroller.EventRestController;
import com.tuanmhoang.springmvc.simplebooking.service.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath*:testContextConfig.xml")
@WebAppConfiguration
public class UserControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders
            .standaloneSetup(new UserController())
            .setViewResolvers(viewResolver)
            .build();
    }

    @Test
    public void test() throws Exception {
        this.mockMvc.perform(
                get("/user")
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("user"));
    }

}
