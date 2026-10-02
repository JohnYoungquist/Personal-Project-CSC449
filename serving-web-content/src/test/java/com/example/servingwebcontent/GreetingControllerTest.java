package com.example.servingwebcontent;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void greetingWithNameAddsProvidedNameToModel() throws Exception {
        mockMvc.perform(get("/greeting").param("name", "John"))
                .andExpect(status().isOk())
                .andExpect(view().name("greeting"))
                .andExpect(model().attribute("name", "John"));
    }

    @Test
    void greetingWithoutNameUsesWorldAsDefault() throws Exception {
        mockMvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andExpect(view().name("greeting"))
                .andExpect(model().attribute("name", "World"));
    }
}
