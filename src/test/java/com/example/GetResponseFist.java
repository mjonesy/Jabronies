package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.Is.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@WebAppConfiguration
public class GetResponseFist {
    @Autowired
    WebApplicationContext webApplicationContext;
    MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getResponseFist_returnsRespnseFist() throws Exception {
        mockMvc.perform(get("/getfisty"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.explosion", is(true)))
                .andExpect(jsonPath("$.bumpId", isA(String.class)));
    }
}
