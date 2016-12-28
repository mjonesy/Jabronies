package com.example;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class FistBumpControllerTest {

    @InjectMocks
    FistBumpController fistBumpController;

    MockMvc mockMvc;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    FistBumpService fistBumpService;

    @Before
    public void setup() {
        mockMvc = standaloneSetup(fistBumpController).build();
    }

    @Test
    public void getFistBump_returnsFistBumpConfirmation() throws Exception {
        when(fistBumpService.bump()).thenReturn("bumpId");

        mockMvc.perform(get("/getfisty"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.explosion", is(true)))
                .andExpect(jsonPath("$.bumpId", is("bumpId")));

        verify(fistBumpService, times(1)).bump();

    }
}
