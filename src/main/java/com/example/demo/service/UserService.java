package com.example.demo.service;

import com.example.demo.client.JsonPlaceHolderRestClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final JsonPlaceHolderRestClient jsonPlaceHolderRestClient;

    public UserService(JsonPlaceHolderRestClient jsonPlaceHolderRestClient) {
        this.jsonPlaceHolderRestClient = jsonPlaceHolderRestClient;
    }

    public List<String> getUsernames() {
        return jsonPlaceHolderRestClient.getusernames();
    }
}
