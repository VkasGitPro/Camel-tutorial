package com.example.restapi;

import org.springframework.stereotype.Component;

@Component
public class Mybean {
    public String getMessage(String mes) {
        return "Hi" + mes;
    }
}
