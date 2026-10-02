package com.example.servingwebcontent;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

class GreetingControllerTest {

    private final GreetingController controller = new GreetingController();

    @Test
    void greetingWithNameAddsProvidedNameToModel() {
        Model model = new ConcurrentModel();
        String viewName = controller.greeting("John", model);
        assertEquals("greeting", viewName);
        assertEquals("John", model.getAttribute("name"));
    }

    @Test
    void greetingWithoutNameUsesWorldAsDefault() {
        Model model = new ConcurrentModel();
        String viewName = controller.greeting(null, model);
        assertEquals("greeting", viewName);
        assertEquals("World", model.getAttribute("name"));
    }
}
