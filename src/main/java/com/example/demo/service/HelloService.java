package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public static final String HELLO_EN = "hello %s";
    public static final String HELLO_SV = "hej %s";

    public String getHelloResponse(String user, String language) {
        if (language.equals("sv")) {
            return String.format(HELLO_SV, user);
        }
        return String.format(HELLO_EN, user);
    }
}
