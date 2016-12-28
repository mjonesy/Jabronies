package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@RestController
public class FistBumpController {

    @Autowired
    FistBumpService fistBumpService;

    @RequestMapping(value = "/getfisty", method = RequestMethod.GET)
    public HashMap<String, Object> getFistBump() {
        HashMap<String, Object> responseFist = new HashMap<>();

        String bumpId = fistBumpService.bump();
        responseFist.put("explosion", true);
        responseFist.put("bumpId", bumpId);
        return responseFist;

    }
}
