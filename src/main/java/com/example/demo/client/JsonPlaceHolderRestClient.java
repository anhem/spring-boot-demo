package com.example.demo.client;

import com.example.demo.configuration.DemoProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JsonPlaceHolderRestClient {

    private final DemoProperties demoProperties;
    private final RestTemplate restTemplate;

    public JsonPlaceHolderRestClient(DemoProperties demoProperties, @Qualifier("timeoutRestTemplate") RestTemplate restTemplate) {
        this.demoProperties = demoProperties;
        this.restTemplate = restTemplate;
    }

    public List<String> getusernames() {
        String url = String.format("%s/users", demoProperties.getJsonPlaceholderBaseUrl());
        UserDTO[] users = restTemplate.getForObject(url, UserDTO[].class);

        return Optional.ofNullable(users)
                .map(Arrays::asList)
                .orElse(Collections.emptyList()).stream()
                .map(UserDTO::getUsername)
                .collect(Collectors.toList());

    }
}
