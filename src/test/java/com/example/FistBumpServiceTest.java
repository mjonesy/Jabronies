package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.util.JdkIdGenerator;

import java.util.UUID;

import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FistBumpServiceTest {
    @InjectMocks
    FistBumpService fistBumpService;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    JdkIdGenerator jdkIdGenerator;

    @Test
    public void bump_returnsBumpId() {
        when(jdkIdGenerator.generateId())
                .thenReturn(UUID.randomUUID());

        String bumpId = fistBumpService.bump();

        assertThat(bumpId, isA(String.class));
        verify(jdkIdGenerator, times(1)).generateId();
    }
}