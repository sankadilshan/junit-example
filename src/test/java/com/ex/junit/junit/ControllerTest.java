package com.ex.junit.junit;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class ControllerTest {

    private MockMvc mvc;

    @InjectMocks
    Controller controller;

    @Before
    public void setUp() throws Exception {
         mvc= MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testHello() throws Exception {
        mvc.perform(
                get("cnt/hello"))
             .andExpect(status().isOk())
             .andExpect(content().string("hello world!"));
    }

    @Test
    public void testSum() {
         assertEquals(3,controller.sum(5,-2));
    }

    @Test
    public void testStudent() throws Exception {
        mvc.perform(get("/cnt/json")
             .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect( jsonPath("$.id"), Matchers.is("IN3200"))
                .andExpect(jsonPath("$.name"), Matchers.is("sanka"));
             //   .andExpect(jsonPath("$.*"), Matchers.hasSize(2));

    }
}