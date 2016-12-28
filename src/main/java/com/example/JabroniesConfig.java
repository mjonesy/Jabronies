package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.JdkIdGenerator;

@Configuration
public class JabroniesConfig {
    @Bean
    public JdkIdGenerator jdkIdGenerator() { return new JdkIdGenerator(); }
}
