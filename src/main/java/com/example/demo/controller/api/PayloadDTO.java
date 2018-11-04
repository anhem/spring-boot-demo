package com.example.demo.controller.api;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PayloadDTO {

    @NotNull
    @Size(min = 1)
    private String message;

    public PayloadDTO() {
    }

    public PayloadDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
