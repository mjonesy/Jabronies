package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.JdkIdGenerator;

@Component
public class FistBumpService {

    @Autowired
    JdkIdGenerator jdkIdGenerator;

    public String bump() {

        return jdkIdGenerator.generateId().toString();
    }
}
