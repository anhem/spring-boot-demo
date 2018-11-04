package com.example.demo.controller.api;

import java.util.UUID;

public class MessageDTO {

    private String message;
    private String randomToken;

    public MessageDTO() {
    }

    public MessageDTO(String message) {
        this.message = message;
        this.randomToken = UUID.randomUUID().toString();
    }

    public String getMessage() {
        return message;
    }

    public String getRandomToken() {
        return randomToken;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRandomToken(String randomToken) {
        this.randomToken = randomToken;
    }
}
