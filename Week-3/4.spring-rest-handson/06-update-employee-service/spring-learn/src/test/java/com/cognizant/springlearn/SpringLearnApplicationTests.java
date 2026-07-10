package com.cognizant.springlearn;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cognizant.springlearn.controller.EmployeeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringLearnApplicationTests {

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private MockMvc mvc;

    @Test
    public void contextLoads() {
        assertNotNull(employeeController);
    }

    @Test
    public void testUpdateEmployeeException() throws Exception {
        String invalidEmployeeJson = "{"
                + "\"id\": 999,"
                + "\"name\": \"Non Existent\","
                + "\"salary\": 50000.0,"
                + "\"permanent\": true,"
                + "\"dateOfBirth\": \"10/10/1990\","
                + "\"department\": {\"id\": 1, \"name\": \"IT\"},"
                + "\"skills\": [{\"id\": 1, \"name\": \"Java\"}]"
                + "}";

        ResultActions actions = mvc.perform(put("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidEmployeeJson));

        actions.andExpect(status().isNotFound());
    }
}
